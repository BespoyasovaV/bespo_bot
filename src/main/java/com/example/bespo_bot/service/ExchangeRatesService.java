package com.example.bespo_bot.service;

import com.example.bespo_bot.client.CbrClient;
import com.example.bespo_bot.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BespoyasovaV
 */
public interface ExchangeRatesService {

    String getUSDExchangeRate() throws ServiceException;
    String getEURExchangeRate() throws ServiceException;
    String getCNYExchangeRate() throws ServiceException;
}
