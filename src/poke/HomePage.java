package poke;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import poke.util.DAO;

import java.util.List;

public class HomePage extends WebPage {

    public HomePage() {
        add(new Label("my_div", "Number of pokemons: " + DAO.getPokemonCount()));

        String name = "ch";
        List<String> nameList = DAO.findPokemonByName(name);
        add(new Label("by_name_count", nameList.size()));
        add(new Label("by_name_names", String.join(", ", nameList)));
    }

}
