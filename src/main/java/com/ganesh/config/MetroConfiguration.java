package com.ganesh.config;

import com.ganesh.persistence.card.CardDao;
import com.ganesh.persistence.card.CardDaoInterface;
import com.ganesh.persistence.station.StationDao;
import com.ganesh.persistence.station.StationDaoInterface;
import com.ganesh.persistence.transaction.TransactionDao;
import com.ganesh.persistence.transaction.TransactionDaoInterface;
import com.ganesh.presentation.MetroPresentation;
import com.ganesh.presentation.MetroPresentationInterface;
import com.ganesh.service.card.CardService;
import com.ganesh.service.card.CardServiceInterface;
import com.ganesh.service.station.StationService;
import com.ganesh.service.station.StationServiceInterface;
import com.ganesh.service.transaction.TransactionService;
import com.ganesh.service.transaction.TransactionServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetroConfiguration {

    @Bean(name = "CardDao")
    public CardDaoInterface getCardDao(){
        return new CardDao();
    }

    @Bean(name = "TransactionDao")
    public TransactionDaoInterface getTransactionDao(){
        return new TransactionDao();
    }

    @Bean(name = "StationDao")
    public StationDaoInterface getStationDao(){
        return new StationDao();
    }

    @Bean(name = "CardService")
    public CardServiceInterface getCardService(){
        CardService cardService = new CardService();
        cardService.setCardDao(getCardDao());
        return cardService;
    }

    @Bean(name = "TransactionService")
    public TransactionServiceInterface getTransactionService(){
        TransactionService transactionService = new TransactionService();
        transactionService.setTransactionDao(getTransactionDao());
        transactionService.setCardDao(getCardDao());
        transactionService.setStationDao(getStationDao());
        return transactionService;
    }

    @Bean(name = "StationService")
    public StationServiceInterface getStationService(){
        StationService stationService = new StationService();
        stationService.setStationDao(getStationDao());
        return stationService;
    }
    @Bean(name = "MetroPresentation")
    public MetroPresentationInterface getMetroPresentation(){
        MetroPresentation metroPresentation = new MetroPresentation();
        metroPresentation.setCardService(getCardService());
        metroPresentation.setTransactionService(getTransactionService());
        metroPresentation.setStationService(getStationService());
        return metroPresentation;
    }
}
/*    <!-->Dao Layer<-->
    <bean id="persistence" class="com.ganesh.persistence.MetroDao" />

    <!-->Service Layer<-->
    <bean id="service" class="com.ganesh.service.MetroService" >
        <property name="metroDao" ref="persistence"/>
    </bean>

    <!-->Presentation Layer<-->
    <bean id="presentation" class="com.ganesh.presentation.MetroPresentation" >
        <property name="metroService" ref="service"/>
    </bean>
*/