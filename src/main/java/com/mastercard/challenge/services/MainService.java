package com.mastercard.challenge.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by ysedn on Jul 13, 2020
 */
@Service
public class MainService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private List<Set<String>> connectedCitiesList = new ArrayList<>();

    private String filePath = "src/main/resources/city.txt";

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean areCitiesConnected(final String origin, final String destination) {
        if (StringUtils.isEmpty(origin) || StringUtils.isEmpty(destination)) {
            return false;
        }

        Set<String> inputSet = new HashSet<>(Arrays.asList(origin, destination));

        if (connectedCitiesList.size() == 0) {
            //loading cities only once for performance gain
            loadConnectedCities();
        }

        for (Set<String> set : connectedCitiesList) {
            if (set.containsAll(inputSet)) {
                return true;
            }
        }
        return false;
    }

    private List<Set<String>> loadConnectedCities() {

        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] cities = myReader.nextLine().split(",");

                if (cities.length != 2 || cities[0].trim().length() == 0 || cities[1].trim().length() == 0) {
                    //skipping this line
                    continue;
                }
                cities[0] = cities[0].trim();
                cities[1] = cities[1].trim();

                int size = connectedCitiesList.size();

                boolean found = false;

                if (size > 0) {
                    Set<String> firstCorrectSet = null;
                    for (Set<String> set : connectedCitiesList) {
                        if (set.contains(cities[0]) || set.contains(cities[1])) {
                            found = true;
                            set.add(cities[0]);
                            set.add(cities[1]);

                            if (firstCorrectSet == null) {
                                firstCorrectSet = set;
                            } else {
                                //putting all connected cities to first found set instead of creating a new one
                                firstCorrectSet.addAll(set);
                                set.clear();
                            }
                        }
                    }
                }
                if (size == 0 || !found) {
                    Set<String> set = new HashSet<>(Arrays.asList(cities[0], cities[1]));
                    connectedCitiesList.add(set);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("File not found", e);
        }
        //remove all zero size elements
        connectedCitiesList.removeIf(e -> e.size() == 0);

        return connectedCitiesList;
    }

}
