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
import br.com.yaw.model.Product;

@RunWith(JUnit4.class)
public class ProductConverterTest {

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
		Product p = new Product();
		String convert = processor.makeConversion(p);
		
		Assert.assertEquals(String.class, convert.getClass());
	}
	
	@Test
	public void convertNotNullTest() {
		Product p = new Product();
		p.setDescription("Mac Book Air");
		p.setValue(2000.5);
		
		Assert.assertNotNull(processor.makeConversion(p));
	}
	
	@Test
	public void convertContentTest() {
		Product p = new Product();
		p.setDescription("Book: Java EE Core");
		p.setValue(30.2);
		
		String text = "{\n  \"description\" : \"Book: Java EE Core\",\n  \"value\" : 30.2\n}";
		String content = processor.makeConversion(p);
		
		Assert.assertTrue(content.contains(text));
	}
}
