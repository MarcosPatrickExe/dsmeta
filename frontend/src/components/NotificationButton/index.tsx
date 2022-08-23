import axios from 'axios';
import icon from '../../assets/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './style.css';
import {toast} from 'react-toastify';

interface Props {
    saleId : number
}
// OU:
/**
    type Props = {
        saleId: number
    }    
 */

function handleClick( id: number ){

     axios.get(`${BASE_URL}/${id}/notification`)
        .then( (response)=>{
                // response.status==200 ? alert("notificao enviada com sucesso!!") : alert("erro de Nº "+response.status);
            
                if( response.status=200 ){      
                    toast.info("SMS enviado com sucesso!!!");
                }
            }
        ).catch( 
            (error)=>{ 
                console.log("erro abaixo:");
                console.log(error)
            } 
        );
}


function NotificationButton( {saleId}:Props ){

    return (
        <div className="dsmeta-red-btn" onClick={ ()=>{ handleClick(saleId) }}>
            <img src={icon} alt="notificar"/>
        </div>
    )

}


export default NotificationButton;