# Portifólio das APIs - Marcos Vinicius Malaquias

Trabalho de graduação consistindo em um portfólio de projetos desenvolvidos durante as APIs: Aprendizado por Projeto Integrador; um projeto semestral interdisciplinar que tem como objetivo propor desafios junto a instiruições parceiras, simulando as necessidades do mercado e a jornada de um desenvolvedor no mundo atual. Este trabalho é apresentado à FATEC - Faculdade de Tecnologia de São José dos Campos como a entrega final para a obtenção da graduação em Banco de Dados.

## Um pouco sobre mim:

Meu nome é Marcos Vínicius Malaquias, sou entusiasta da programação e apaixonado por tecnologia. Estou cursando minha primeira graduação e escolhi o curso de Banco de Dados como uma forma de ingressar no mercado de tecnologia. 

Sou uma pessoa criativa, resiliente e analítica, escolhi a área de tecnologia devido à sua relevância na sociedade atual e também às projeções que indicam o crescimento contínuo dessa área nos próximos anos.

## Meus projetos

### Khali 3 - Aplicação Java Web para controle da jornada de trabalho

3º Semestre | 2023-2

Parceiro academico: `2RP`
Back-end: `Java`
Front-end: `React`
Banco de dados: `Postgres` 

A aplicação Khali 3 é uma API Java web para o gerenciamento de horas extras e sobreavisos. Seu principal objetivo é controlar os apontamentos/solicitações de horas extras e sobreavisos realizados pelos colaboradores. Além disso, o sistema interpreta essas solicitações, direcionando-as aos responsáveis pela aprovação ou recusa. Caso aprovadas, o sistema realiza cálculos para determinar a quantidade de horas a serem pagas para cada colaborador, com base na parametrização configurada pelo setor de recursos humanos.

### Arquitetura do projeto

### Funcionalidades

### Tecnologias utilizadas

### Contribuições Individuais

Dentro do sistema eu atuei de forma fullstack contribundo desde a modelagem do banco até as estilizações do front-end. 

Banco de dados:
 - Contribui com a modelagem dos banco definindo as relações, criando as tabelas e constraints. Dentre as demandas, um se destaca, a tabela `notification`, uma tabela que gerenciava as notificações dos usuario, para avisar sempre que uma solicitação havia sido atualizado. A principio iriamos utilizar um banco Nosql, mas por questões de tempo optamos por utilizar um banco relacional mas com o objetivo de reduzir ao maximos o uso de recursos do banco.
 - 
<br>

<details>
<summary> Alguns exemplo do que foi desenvolvido:  </summary>


```sql

DROP TABLE IF EXISTS clients CASCADE;
CREATE TABLE IF NOT EXISTS clients(
    clt_id SERIAL PRIMARY KEY,
    "name" VARCHAR(255),
    cnpj VARCHAR(255) UNIQUE,
    insert_date TIMESTAMP DEFAULT now(),
    expire_date TIMESTAMP
);


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE IF NOT EXISTS users(
    usr_id SERIAL PRIMARY KEY,
    registration VARCHAR(255) UNIQUE NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    user_type User_type DEFAULT 'Employee',
    email VARCHAR(255) UNIQUE NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    insert_date TIMESTAMP DEFAULT now(),
    expire_date TIMESTAMP
);

DROP TABLE IF EXISTS appointments CASCADE;
CREATE TABLE IF NOT EXISTS appointments(
    apt_id SERIAL PRIMARY KEY,
    start_date TIMESTAMP check (start_date < end_date) NOT NULL,
    end_date TIMESTAMP check (end_date > start_date) NOT NULL,
    usr_id INT,
    clt_id INT,
    rc_id INT,
    prj_id INT,
    appointment_type Apt_type NOT NULL,
    justification VARCHAR(255),
    status Apt_status DEFAULT 'Pending',
    insert_date TIMESTAMP DEFAULT now(),
    apt_updt_id INT NULL,
    feedback VARCHAR(255),

    CONSTRAINT usr_id_fk FOREIGN KEY
    (usr_id) REFERENCES users(usr_id),
    CONSTRAINT clt_id_fk FOREIGN KEY
    (clt_id) REFERENCES clients(clt_id),
    CONSTRAINT rc_id_fk FOREIGN KEY
    (rc_id) REFERENCES result_centers(rc_id),
    CONSTRAINT apt_updt_fk FOREIGN KEY
    (apt_updt_id) REFERENCES appointments(apt_id),
    CONSTRAINT prj_id_fk FOREIGN KEY (prj_id) REFERENCES projects(prj_id)
);

DROP TABLE IF EXISTS notifications CASCADE;
CREATE TABLE IF NOT EXISTS notifications (
    apt_id INT PRIMARY KEY,
    usr_id integer,
    status boolean DEFAULT false,
    type apt_status DEFAULT 'Pending',
    CONSTRAINT fk_apt_id FOREIGN KEY
    (apt_id) REFERENCES appointments(apt_id),
    CONSTRAINT fk_usr_id FOREIGN KEY
    (usr_id) REFERENCES users(usr_id)
);

```
<br>
</details>

<br>

 Back-end:
 - No back-and eu pude atuar em todas as camadas da aplicação: Criando as entity, repository, service e controllers das tabelas e objetos `user`, `appoinment` e `client`, uma das minhas melhores contribuições e mais complicadas foi a entidade `notification`:


Aqui temos a entidade criada conforme a tabela no banco. Cada apontamento solicitado no sistema deve gerar uma notificação para o responsavél por aquele colaborador, assim ele obtem a aprovação ou recusa, facilitando a gestão e acompanhamento das solicitações. Nesse contexto nossa aplicação possui 4 atributos:
- aptId: Id do apontamento referente a essa notificação;
- userId: Id do usario que deverá aprovar essa notificação;
- status: status da notificação, se já foi visualizada ou não;
- AppointmentStatus: Status do apontamento referente a essa notificação.

<details>
<summary> Código </summary>

```java

//Entity
 
@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apt_id")
    private Long aptId;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User userId;

    @Column(name = "status")
    private boolean status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AppointmentStatus type;

}

// Repository

@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}

 ```
<br>
</details>

Como as notificações funcionava:

1 - Ao fazer uma solicitação, um novo registro era criado na tabela notificações, associando o seu apontamento ao seu gestor;

2 - Assim que seu gestor entra na aba de notificações ou na tela de aprovações, a notificação muda de status, assim a notificação ficará oculta pois o gestor já foi notificado;

3 - Assim que o gestor atualização sua solicitação, aprovando ou recusando, a tabela de notificações também é atualizada e a notificação ganha um novo status, mas dessa vez ela aparece para o solicitando, notificando que seu apontamento foi atualizado.

4 - Ao vizualizar a notificação, um gatilho deleta aquele registro no banco, assim poupando armazenamento. 

<details>
<summary> Código </summary>


```java
// Como a notification estava muito ligada ao appoinments, optamos por deixar um unico service e incluir o notification

// Service

    @Query(value = "SELECT * FROM appointments a WHERE a.usr_id = :usr_id", nativeQuery = true)
    List<Appointment> findAppointmentByUser(@Param("usr_id") Long userId);

    @Query(value = "select * from appointments where rc_id in ( select rc_id from result_centers where gst_id = :usr_id) and status = 'Pending'", nativeQuery = true)
    List<Appointment> findByManager(@Param("usr_id") Long userId);

    @Query(value = "select * from appointments where rc_id in ( select rc_id from result_centers where gst_id = :usr_id)", nativeQuery = true)
    List<Appointment> findAllByManager(@Param("usr_id") Long userId);

    @Query(value = "update appointments set status = :#{#status.name()} where apt_id = :apt_id returning *", nativeQuery = true)
    Optional<Appointment> updateStatusAppointment(
        @Param("apt_id") Long apt_id,
        @Param("status") AppointmentStatus status
    );

    @Modifying
    @Query(value = "INSERT INTO notifications (apt_id, usr_id, type) VALUES (:aptId, :userId, 'Pending')", nativeQuery = true)
    void insertNotification(@Param("aptId") Long appointmentId, @Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE notifications SET type = 'Rejected' WHERE apt_id = :aptId", nativeQuery = true)
    void updateToRejected(@Param("aptId") Long appointmentId);

    @Modifying
    @Query(value = "UPDATE notifications SET type = 'Approved' WHERE apt_id = :aptId", nativeQuery = true)
    void updateToApproved(@Param("aptId") Long appointmentId);

    @Modifying
    @Query(value =
        "UPDATE notifications " +
        "SET status = true " +
        "WHERE usr_id = :usr_id " +
        "AND type IN ('Rejected', 'Approved') " +
        "AND status = false",
        nativeQuery = true)
    void updateStatusToTrueForUser(@Param("usr_id") Long usr_id);

    @Query(value =
        "SELECT COUNT(*) FROM notifications n " +
        "WHERE n.apt_id IN (SELECT a.apt_id FROM appointments a " +
        "WHERE a.rc_id IN (SELECT rc.rc_id FROM result_centers rc WHERE rc.gst_id = :usr_id) " +
        "AND a.status = 'Pending')",
        nativeQuery = true)
    long countPendingNotificationsForManager(@Param("usr_id") Long userId);

    @Query(value =
        "SELECT COUNT(*) FROM notifications WHERE usr_id = :usr_id " +
        "AND status = false AND (type = 'Rejected' OR type = 'Approved')",
        nativeQuery = true)
    long countFalseRejectedOrApprovedNotifications(@Param("usr_id") Long userId);


// Controller

    @Transactional
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentRepository.save(appointment);
        appointmentRepository.insertNotification(savedAppointment.getId(), savedAppointment.getUser().getId());
        return savedAppointment;
    }

    @Transactional
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id)

                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + id));
        appointmentRepository.save(appointmentDetails);

        appointment.setApt_updt(appointmentDetails.getId());
        return appointmentRepository.save(appointment);
    }

    @Transactional
    @PutMapping("/validate/{id}")
    public Appointment updateAppointmentWithStatus(
            @PathVariable Long id,
            @RequestParam(name = "index") int index,
            @RequestParam(name = "feedback") String feedback) throws Exception {
        if (index != 1 && index != 2) {
            throw new Exception("O valor passado deve ser 1 ou 2");
        }
    
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + id));
    
        AppointmentStatus status = AppointmentStatus.of(index);
        // appointment.setStatus(status);
        appointmentRepository.updateStatusAppointment(id, status);
        appointment.setFeedback(feedback);
        appointment = appointmentRepository.save(appointment);
    
        if (status == AppointmentStatus.Rejected) {
            appointmentRepository.updateToRejected(id);
        } else if (status == AppointmentStatus.Approved) {
            appointmentRepository.updateToApproved(id);
        }
        return appointment;
    }
    

    @GetMapping("/notification/{usr_id}")
    public List<Long> notificationAppointment(@PathVariable Long usr_id) {
        List<Long> notification = new ArrayList<>();
        
        long pendingNotificationsForManager = appointmentRepository.countPendingNotificationsForManager(usr_id);
        notification.add(pendingNotificationsForManager);
        
        long falseRejectedOrApprovedNotifications = appointmentRepository.countFalseRejectedOrApprovedNotifications(usr_id);
        notification.add(falseRejectedOrApprovedNotifications);
        
        return notification;
    }
    
    @Transactional
    @PutMapping("/notification/update/{usr_id}")
    public void updateNotificationsStatusToTrue(@PathVariable Long usr_id) {
        appointmentRepository.updateStatusToTrueForUser(usr_id);
    }
```
<br>
</details>

Front-end

Para o front nos trabalhamos a componentização, onde criamos componentes modulares e genericos, associando conteudo conforme o contexto. Entre as principais colaborações seria os dashboard, graficos e a mensageria:

<details>

<summary> </summary>

```tsx
import { useEffect, useState } from 'react';
import BarChartDays from '../components/BarChartDaysOfMonth';
import BarChartHours from '../components/BarChartHoursOfDay';
import Filter from '../components/Filter';
import PieChart from '../components/PieChart';
import { AppointmentSchema } from '../schemas/Appointment';
import { UserSchema } from '../schemas/User';
import { getAppointmentsUser } from '../services/AppointmentService';
import "../styles/dashboard.css";

interface AppointmentsProps {
    userLoggedIn: UserSchema;
}

export default function Appointments({ userLoggedIn }: AppointmentsProps) {
    const [appointments, setAppointments] = useState<AppointmentSchema[]>([]);
    const [filtered, setFiltered] = useState<AppointmentSchema[]>([]);

    const [filterValues, setFilterValues] = useState<{ [key: string]: any }>({
        "type": "",
        "status": "",
        "client": "",
        "resultCenter": "",
        "project": "",
        "startDate": "",
        "endDate": "",
    });


    const requestAppointments = () => {
        getAppointmentsUser(userLoggedIn.id)
            .then(appointmentsResponse => {
                setAppointments(appointmentsResponse);
                applyFilters(filterValues, appointmentsResponse);
            });
    }

    useEffect(() => {
        requestAppointments();
    }, []);

    const handleFilterChange = (filterType: string, filterValue: any) => {
        // Para datas, garantimos que o formato esteja correto antes de definir no estado
        const formattedDate = filterValue instanceof Date ? filterValue.toLocaleDateString() : filterValue;

        const newFilterValues = { ...filterValues, [filterType]: formattedDate };
        setFilterValues(newFilterValues);
        applyFilters(newFilterValues, appointments);
        console.log(newFilterValues);
    };

    const applyFilters = (filters: { [key: string]: any }, data: AppointmentSchema[]) => {
        const newFiltered = data.filter((appointment) => {
            return Object.keys(filters).every((filterType) => {
                const filterValue = filters[filterType];
                if (filterValue === null || filterValue === undefined || filterValue === '') {
                    return true;
                }
                switch (filterType) {
                    case "type":
                        return appointment.type === filterValue;
                    case "status":
                        return appointment.status === filterValue;
                    case "client":
                        return appointment.client === filterValue;
                    case "resultCenter":
                        return appointment.resultCenter === filterValue;
                    case "project":
                        return appointment.project === filterValue;
                    case "startDate":
                        const filterStartDate = new Date(filterValue);
                        const appointmentStartDate = new Date(appointment.startDate);
                        /* Compare the dates without considering time components */
                        return filterStartDate.setHours(0, 0, 0, 0) <= appointmentStartDate.setHours(0, 0, 0, 0);
                    case "endDate":
                        const filterEndDate = new Date(filterValue);
                        const appointmentEndDate = new Date(appointment.endDate);
                        /* Compare the dates without considering time components */
                        return filterEndDate.setHours(0, 0, 0, 0) >= appointmentEndDate.setHours(0, 0, 0, 0);
                    default:
                        return true;

                }
            });
        });

        // Atualiza o array filtrado
        setFiltered(newFiltered);
        console.log(newFiltered);
    };

    return (
        <div className="dashabord-admin-page">
            <div className="filters">
                <Filter
                    type="selection"
                    options={[
                        { label: 'Todos', value: '' },
                        { label: 'Hora Extra', value: 'Overtime' },
                        { label: 'Sobreaviso', value: 'OnNotice' },
                    ]}
                    onFilterChange={(value) => handleFilterChange("type", value)}
                />
                <Filter
                    type="selection"
                    options={[
                        { label: 'Todos', value: '' },
                        { label: 'Pendente', value: 'Pending' },
                        { label: 'Aprovados', value: 'Approved' },
                        { label: 'Recusados', value: 'Rejected' },
                    ]}
                    onFilterChange={(value) => handleFilterChange("status", value)}
                />
                <Filter
                    type="availableClients"
                    onFilterChange={(value) => handleFilterChange("client", value)}
                />
                <Filter
                    type="availableResultCenters"
                    onFilterChange={(value) => handleFilterChange("resultCenter", value)}
                    userLoggedIn={userLoggedIn}
                />
                <Filter
                    type="availableProjects"
                    onFilterChange={(value) => handleFilterChange("project", value)}
                />
                <Filter
                    type="date-start"
                    onFilterChange={(value) => handleFilterChange("startDate", value)}
                />
                <Filter
                    type="date-end"
                    onFilterChange={(value) => handleFilterChange("endDate", value)}
                />
            </div>
            <div className="charts-line1">
                <PieChart data={filtered} />
                <BarChartHours data={filtered} />
            </div>
                <div className="charts-line2">
                    <BarChartDays data={filtered} />
            </div>
            </div>
    );
}

```

</details>

Scrum Master

 - Responsavél pelo criacão do Backlog das sprint;
 - Responsavél pelo gerenciamento das tarefas;
 - Criação e acompanhamento do Burndown;
 - Mediador das reuniões;
 - Facilitador da equipe;


<details>
<summary> Código </summary>
<br>
</details>

Desenvolvimento Front-end

 - Criação das principais telas da aplicação;
 - Criação dos compontentes;
 - Configuração das routas dentro do componente principal (Home)

Desenvolvimento Back-end

 - Criação dos endopoint
 - Criação das funções

Documentação
 - Responsavél pela contrução do README

##### Lições Aprendidas

Tive diversos aprendizados nesse projeto, foi a primeira vez criando uma API Web e utilizando o spring boot.

Um grande aprendizado de fato foi a utilização do protocolo `http` para a tranferencia de inform
