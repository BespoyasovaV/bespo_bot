package com.example.bespo_bot.service.mplementation;

import com.example.bespo_bot.client.CbrClient;
import com.example.bespo_bot.exception.ServiceException;
import com.example.bespo_bot.service.ExchangeRatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;


import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;


/**
 * @author BespoyasovaV
 */
@Service
public class ExchangeRatesServiceImplementation implements ExchangeRatesService {
    @Autowired
    private CbrClient client;
    private static final String USD_XPATH = "//ValCurs//Valute[@ID='R01235']/Value ";
    private static final String EUR_XPATH = "/ValCurs//Valute[@ID='R01239']/Value ";
    private static final String CNY_XPATH = "/ValCurs//Valute[@ID='R01375']/Value ";

    @Override
    public String getUSDExchangeRate() throws ServiceException {
        String xml = client.getCurrencyRatesXML();
        return extractCurrencyValueFromXML(xml, USD_XPATH);
    }

    @Override
    public String getEURExchangeRate() throws ServiceException {
        String xml = client.getCurrencyRatesXML();
        return extractCurrencyValueFromXML(xml, EUR_XPATH);
    }

    @Override
    public String getCNYExchangeRate() throws ServiceException {
        String xml = client.getCurrencyRatesXML();
        return extractCurrencyValueFromXML(xml, CNY_XPATH);
    }

    //достаем валюту из xml
    private static String extractCurrencyValueFromXML(String xml, String xpathExpression)
            throws ServiceException {
        var source = new InputSource(new StringReader(xml));
        try {
            var xpath = XPathFactory.newInstance().newXPath();
            var document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);

            return xpath.evaluate(xpathExpression, document);
        } catch (XPathExpressionException e) {
            throw new ServiceException("Не удалось распарсить XML", e);
        }
    }

}
