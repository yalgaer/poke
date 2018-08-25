package poke.util;

import poke.PokeApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static int getPokemonCount() {
        int count = -1;
        try (Connection c = PokeApplication.get().getDataSource().getConnection()) {
            try (ResultSet rs = c.createStatement().executeQuery("SELECT COUNT(*) FROM poks")) {
                rs.next();
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static List<String> findPokemonByName(String name) {
        List<String> nameList = new ArrayList<>();
        try (Connection c = PokeApplication.get().getDataSource().getConnection()) {
            try (ResultSet rs = c.createStatement().executeQuery("SELECT name FROM poks WHERE name LIKE '%" + name + "%'")) {
                while (rs.next()) {
                    String pokemonName = rs.getString("name");
                    nameList.add(pokemonName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameList;
    }
}
