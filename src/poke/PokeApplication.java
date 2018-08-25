package poke;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import javax.sql.DataSource;

public class PokeApplication extends WebApplication {

    private final HikariDataSource ds = new HikariDataSource();

    @Override
    protected void init() {
        super.init();

        ds.setJdbcUrl("jdbc:mysql://localhost:3306/poke");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("12345");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ds.close();
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    public static PokeApplication get() {
        return (PokeApplication) WebApplication.get();
    }

    public DataSource getDataSource() {
        return ds;
    }
}