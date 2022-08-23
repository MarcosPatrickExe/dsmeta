import axios from "axios";
import NotificationButton from '../NotificationButton';
import './style.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { useEffect, useState } from 'react';
import { BASE_URL} from "../../utils/request";
import { Sale } from "../../models/sale";


// SHIFT + ALT + F (identa codigo)

function SalesCard() {
    
    let min = new Date(
                    new Date().setDate( 
                            new Date().getDate()-365 
                    ) 
              );

    const [minDate, setMinDate] = useState( min );
    const [maxDate, setMaxDate] = useState( new Date() );//data atual
                       
                        // A FUNCAO 'useState()' EH DO TIPO Sale[]
    const [sales, setSales] = useState<Sale[]>([]);
    
    useEffect( ()=>{

        const dminFormatada = minDate.toISOString().slice(0, 10);
        const dmaxFormatada = maxDate.toISOString().slice(0, 10);

      //  console.log("teste");

        // ....com/sales/salesList (retorna todos os objetos no formato 'list')
        // ....com/sales/allSalesPage (retorna todos os objetos no formato de 'pages')
        // ....com/sales/salesPage (recebe minDate e maxDate como parametros e retorna uma page<Sale>)
        // ....com/sales/{id}/notification (recebe uma variable junto ao caminho
        
   //   axios.get("https://patrick-dsmeta-backend.herokuapp.com/sales/salesList")
        axios.get(`${BASE_URL}/salesPage?minDate=${dminFormatada}&maxDate=${dmaxFormatada}`)
            .then( (response)=>{
              //   console.dir( JSON.stringify(response.data, null, 4)  );

                 if( response.data.hasOwnProperty('content') ){
                    setSales(
                        response.data.content // NECESSITA DE 'content' UMA VEZ QUE A REQUISICAO RETORNA UM 'PAGE'
                    );

                 }else{
                    setSales(
                        response.data //NAO PRECISA DO .content CASO A REQUISICAO RETORNE UM 'LIST'
                    );
                 }

            })

    }, [minDate, maxDate]);

    return (
        <div className="dsmeta-card">
                <h2 className="dsmeta-sales-title">Vendas</h2>
                <div>
                    <div className="dsmeta-form-control-container">
                          {/* 
                              <input className="dsmeta-form-control" type="text" />
                          */}
                          <DatePicker 
                              selected={ minDate }
                              onChange={ (date: Date)=> setMinDate(date) }
                              className="dsmeta-form-control"
                              dateFormat="dd/MM/yyyy"
                          />
                    </div>
                    <div className="dsmeta-form-control-container">
                          {/* 
                              <input className="dsmeta-form-control" type="text" />
                          */}
                          <DatePicker 
                              selected={ maxDate }
                              onChange={ (date: Date)=> setMaxDate(date) }
                              className="dsmeta-form-control"
                              dateFormat="dd/MM/yyyy"
                          />
                    </div>
                </div>

                <div>
                   <table className="dsmeta-sales-table">

                        <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                        </thead>


                        <tbody>
                            { /* renderizacao de conteudo baseado em uma lista */ }
                            
                            {
                                (sales!=null) &&(

                                    sales.map( (sale)=>{
                                        return (
                                            <tr key={sale.id}>
                                                    <td className="show992">{sale.id}</td>
                                                    <td className="show576">
                                                        { 
                                                            new Date(sale.date)
                                                                .toLocaleString()
                                                                    .substring(0, 10) 
                                                        }
                                                    </td>
                                                    <td>{sale.sellerName}</td>
                                                    <td className="show992">{sale.visited}</td>
                                                    <td className="show992">{sale.deals}</td>
                                                    <td>{sale.amount.toFixed(2)}</td>
                                                    <td>
                                                        <div className="dsmeta-red-btn-container">
                                                            <NotificationButton saleId={sale.id}/>
                                                        </div>
                                                    </td>
                                            </tr>
                                        ) 
                                    })
                                    
                                )
                            }
                        </tbody>
                   </table>
                </div>
        </div>
    )
}


export default SalesCard;