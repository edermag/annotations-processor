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

@RunWith(JUnit4.class)
public class ConvertersTest {

    private static ConverterProcessor processor;
	
	@BeforeClass
	public static void init() {
		List<ConverterTypeEntry> entries = ConverterLoader.loadConverters();
		ConverterRepository repository = ConverterRepository.create(entries);
		processor = new ConverterProcessor();
		processor.setRepository(repository);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullableContentTest() {
		processor.makeConversion(null);
	}
	
	@Test
	public void unknowConverterTest() {
		Assert.assertNotNull(processor.makeConversion("XYZ"));
		Assert.assertNotNull(processor.makeConversion(new Integer(101)));
	}
}
