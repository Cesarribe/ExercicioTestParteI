import static org.junit.Assert.*;

import org.example.Pessoa;
import org.example.SepararPorSexo;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class SepararPorSexoTest {

    private List<Pessoa> pessoas;

    @Before
    public void setUp() {
        pessoas = new ArrayList<>();
    }

    @Test
    public void testListaContemApenasMulheres() {
        pessoas.add(new Pessoa("Maria", 'F'));
        pessoas.add(new Pessoa("João", 'M'));
        pessoas.add(new Pessoa("Ana", 'F'));

        List<Pessoa> mulheres = SepararPorSexo.filtrarGenero(pessoas, 'F');

        assertTrue(mulheres.stream().allMatch(p -> p.getSexo() == 'F'));
    }

    @Test
    public void testListaNaoContemApenasMulheres() {
        pessoas.add(new Pessoa("Maria", 'F'));
        pessoas.add(new Pessoa("João", 'M'));
        pessoas.add(new Pessoa("Ana", 'F'));
        pessoas.add(new Pessoa("Carlos", 'M'));

        List<Pessoa> mulheres = SepararPorSexo.filtrarGenero(pessoas, 'F');

        assertFalse(mulheres.stream().allMatch(p -> p.getSexo() == 'F'));
    }
}