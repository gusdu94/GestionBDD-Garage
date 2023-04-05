package dao;

import models.Voiture;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoitureDao {

    private Connection connection;
    public VoitureDao(Connection connection) {
        this.connection = connection;
    }

    public List<Voiture> getVoiture() throws SQLException {
        String selectVoitures = "SELECT * FROM Voiture";
        List<Voiture> voitures = new ArrayList<>();

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectVoitures);
        while (resultSet.next()) {
            voitures.add(new Voiture(resultSet.getInt("id"),resultSet.getString("marque"),resultSet.getString("model"),resultSet.getDate("date"),resultSet.getString("couleur"),resultSet.getString("etat")));
        }

        return voitures;
    }

    public void setVoiture(String marque, String model,String Etat,String date, String couleur) throws SQLException{
        String sql = "INSERT INTO Voiture (marque, model, couleur, date, etat) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, marque);
        statement.setString(2, model);
        statement.setString(3, couleur);
        statement.setString(4, date);
        statement.setString(5, Etat);
        int rowsAffected = statement.executeUpdate();
    }

    public void DeletVoiture(String id) throws SQLException{
        String sql = "DELETE FROM Voiture WHERE Id = "+id ;
        PreparedStatement statement = connection.prepareStatement(sql);
        int rowsAffected = statement.executeUpdate();
    }

    public void UpdateVoiture(String column,String id, String modif) throws SQLException{
        String sql = "UPDATE Voiture SET "+column+" = '"+modif+"' WHERE ID = "+id;
        PreparedStatement statement = connection.prepareStatement(sql);
        int rowsAffected = statement.executeUpdate();
    }
}