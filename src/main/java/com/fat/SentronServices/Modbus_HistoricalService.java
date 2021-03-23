package com.fat.SentronServices;


import com.fat.SentronEntities.Modbus_historical;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class Modbus_HistoricalService  {

@PersistenceContext
private EntityManager entityManager;

    public List<Modbus_historical> getHistoricalValue_basedOnRowLimit(int records, String variableName) {
        return entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1  ORDER BY id DESC",
                Modbus_historical.class)
                .setParameter(1, variableName)
                .setMaxResults(records)
                .getResultList();
    }

    public List<Modbus_historical> getHistoricalValues_basedOnTimePeroid(String timePeroid, String variableName) {

        List<Modbus_historical> resultList = null;

        switch (timePeroid) {

            case("yesterday") :
               resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  >= CURRENT_DATE - 1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') = CURRENT_DATE -1 " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            case("today") :
                resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  = CURRENT_DATE " +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') = CURRENT_DATE " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            case("week") :
                resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  >= CURRENT_DATE -7 " +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') <= CURRENT_DATE " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            case("month") :
                resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  >= CURRENT_DATE - 30 " +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') <= CURRENT_DATE " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            case("3month") :
                resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  >= CURRENT_DATE - 90 " +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') <= CURRENT_DATE " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            case("year") :
                resultList = entityManager.createQuery("FROM Modbus_historical mh WHERE variable = ?1" +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD')  >= CURRENT_DATE - 365 " +
                                "AND  TO_DATE(mh.last_date , 'YYYY-MM-DD') <= CURRENT_DATE " +
                                "ORDER BY id DESC",
                        Modbus_historical.class)
                        .setParameter(1, variableName)
                        .getResultList();
                break;

            default:
                System.out.println("there is no possibility to retrieve data from Historical Table - modbus");
                break;
        }

        return  resultList;
    }

}
