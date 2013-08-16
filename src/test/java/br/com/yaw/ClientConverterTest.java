package br.com.yaw;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.com.yaw.config.ConverterLoader;
import br.com.yaw.config.ConverterLoader.ConverterTypeEntry;
import br.com.yaw.config.ConverterProcessor;
import br.com.yaw.config.ConverterRepository;
import br.com.yaw.model.Client;

@RunWith(JUnit4.class)
public class ClientConverterTest {

	private static ConverterProcessor processor;
	
	@BeforeClass
	public static void init() {
		List<ConverterTypeEntry> entries = ConverterLoader.loadConverters();
		ConverterRepository repository = ConverterRepository.create(entries);
		processor = new ConverterProcessor();
		processor.setRepository(repository);
	}
	
	@Test
	public void convertTypeReturn() {
		Client c = new Client();
		String convert = processor.makeConversion(c);
		
		Assert.assertEquals(String.class, convert.getClass());
	}
	
	@Test
	public void convertNotNullTest() {
		Client c = new Client();
		c.setName("Jose da Silva");
		c.setAddress("Av Paulista");
		
		Assert.assertNotNull(processor.makeConversion(c));
	}
	
	@Test
	public void convertContentTest() {
		Client c = new Client();
		c.setName("Pedro");
		c.setAddress("Av Paulista");
		String text = String.format("Client: %s - Address: %s", c.getName(), c.getAddress());
		
		Assert.assertEquals(text, processor.makeConversion(c));
	}
	
}
