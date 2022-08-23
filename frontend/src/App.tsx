//import react from 'react'
import './App.css'
import Header from './components/Header/index';
import SalesCard from './components/SalesCard/index';
import {ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

// CTRL + K S (abre o guia de atalhos do teclado no vscode)
function App() {
 
    return (
        <>
            <ToastContainer />
            <Header />
            <main>
              <section id="sales">
                <div className="dsmeta-container">
                    <SalesCard />
                </div>
              </section>
            </main>           
        </>
    )
}

export default App;;

// pagia semana spring react: 
// https://devsuperior.com.br/evento-sds?episodio=1

// link do repositorio:
// https://github.com/devsuperior/sds-dsmeta

// dsmeta html + css:
// https://github.com/acenelio/dsmeta-css

