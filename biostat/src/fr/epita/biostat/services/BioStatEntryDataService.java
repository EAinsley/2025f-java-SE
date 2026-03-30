package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BioStatEntryDataService {


    public BioStatEntryDataService() throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                        CREATE TABLE BIOSTATS (
                            name varchar(255),
                            sex char,
                            age int
                        )                        
                    """);
            preparedStatement.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw sqle;
        }

    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_ClOSE_DELAY=-1");
    }

    public List<BioStatEntry> search(BioStatEntry qbe) throws SQLException {
        return null;
    }

    public void create(BioStatEntry entry) throws SQLException {

        try (Connection connection = getConnection()) {
            String insertQuery = """
                    
                       INSERT INTO BIOSTATS(name, sex, age) values (?, ?, ?)
                    
                    """;
            PreparedStatement insertStatement = connection.prepareStatement(
                    insertQuery);
            //TODO set parameters
            insertStatement.setString(1, entry.getName());
            insertStatement.execute();
        }

    }

    public void update(BioStatEntry entry) {

    }

    public void delete(BioStatEntry entry) {

    }


}
