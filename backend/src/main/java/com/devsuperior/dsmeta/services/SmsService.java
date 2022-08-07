package com.devsuperior.dsmeta.services;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Patrick
 */

@Service
public class SmsService {
    
        @Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

        @Autowired
        private SaleRepository saleRepository;
        
        
	public void sendSms(Long saleId) {
            
                Sale sale = this.saleRepository.findById(saleId).get();
                
                String msg = "O(a) vendedor(a)"+sale.getSellerName()+
                             " com "+sale.getVisited()+" visitas"+
                             " realizou "+sale.getDeals()+" venda(s)"+
                             " na data: '"+sale.getDate()+"' ("+sale.getDate().getMonth()+"/"+sale.getDate().getYear()+")"+
                             " e totalizou: R$"+ String.format("%.2f", sale.getAmount());
                
		Twilio.init( this.twilioSid, this.twilioKey );

		PhoneNumber to = new PhoneNumber( this.twilioPhoneTo);
		PhoneNumber from = new PhoneNumber( this.twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println( message.getSid() );
	}
}
