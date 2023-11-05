import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.tsx'; // Se o seu aplicativo principal estiver em outro arquivo, importe-o aqui.

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);