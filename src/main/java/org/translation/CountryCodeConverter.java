package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the service of converting country codes to their names.
 */
public class CountryCodeConverter {

    private final ArrayList<String> countryName;
    private final ArrayList<String> countryAlpha2Code;
    private final ArrayList<String> countryAlpha3Code;
    private final ArrayList<String> countryNumericCode;
    // TODO Task: pick appropriate instance variable(s) to store the data necessary for this class

    /**
     * Default constructor which will load the country codes from "country-codes.txt"
     * in the resources folder.
     */
    public CountryCodeConverter() {
        this("country-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the country code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public CountryCodeConverter(String filename) {

        countryName = new ArrayList<>();
        countryAlpha2Code = new ArrayList<>();
        countryAlpha3Code = new ArrayList<>();
        countryNumericCode = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));

            // TODO Task: use lines to populate the instance variable(s)
            for (String line : lines.subList(1, lines.size())) {
                String[] parts = line.split("\t");
                countryName.add(parts[0]);
                countryAlpha2Code.add(parts[1]);
                countryAlpha3Code.add(parts[2]);
                countryNumericCode.add(parts[3]);
            }
        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the country for the given country code.
     * @param code the 3-letter code of the country
     * @return the name of the country corresponding to the code
     */
    public String fromCountryCode(String code) {
        // TODO Task: update this code to use an instance variable to return the correct value
        int i = countryAlpha3Code.indexOf(code.toUpperCase());
        return countryName.get(i);
    }

    /**
     * Returns the code of the country for the given country name.
     * @param country the name of the country
     * @return the 3-letter code of the country
     */
    public String fromCountry(String country) {
        // TODO Task: update this code to use an instance variable to return the correct value
        return countryAlpha3Code.get(countryName.indexOf(country));
    }

    /**
     * Returns how many countries are included in this code converter.
     * @return how many countries are included in this code converter.
     */
    public int getNumCountries() {
        // TODO Task: update this code to use an instance variable to return the correct value
        return countryName.size();
    }
}
