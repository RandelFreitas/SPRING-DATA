package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringDataTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeInsert() {

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();

		usuarioSpringData.setEmail("javaavancado@javaavancado.com");
		usuarioSpringData.setIdade(31);
		usuarioSpringData.setLogin("teste 123");
		usuarioSpringData.setSenha("123");
		usuarioSpringData.setNome("Egidio");

		interfaceSpringDataUser.save(usuarioSpringData);

		System.out.println("Usuario cadastrado -> " + interfaceSpringDataUser.count());

	}

	@Test
	public void testeConsulta() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getIdade());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getSenha());
		System.out.println(usuarioSpringData.get().getId());
	}

	@Test
	public void testeConsulaTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------");
		}
	}

	@Test
	public void testeUpdate() {

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setNome("Alex Egidio Update Spring Data");
		data.setIdade(25);

		interfaceSpringDataUser.save(data);
	}

	@Test
	public void testeDelete() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(3L);

		interfaceSpringDataUser.delete(usuarioSpringData.get());
	}

	@Test
	public void testeConsultaNome() {

		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Alex");

		for (UsuarioSpringData usuarioSpringData : list) {

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------");
		}
	}
	
	
	@Test
	public void testeConsultaNomeParam() {

		UsuarioSpringData usuarioSpringData = interfaceSpringDataUser.buscaPorNomeParam("Egidio");

			System.out.println(usuarioSpringData.getEmail());
			System.out.println(usuarioSpringData.getIdade());
			System.out.println(usuarioSpringData.getLogin());
			System.out.println(usuarioSpringData.getNome());
			System.out.println(usuarioSpringData.getSenha());
			System.out.println(usuarioSpringData.getId());
			System.out.println("---------------------------------------------------");
	}

}
