package ch.interlis.iox_j.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.config.Configuration;
import ch.interlis.ili2c.config.FileEntry;
import ch.interlis.ili2c.config.FileEntryKind;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom.IomConstants;
import ch.interlis.iom.IomObject;
import ch.interlis.iom_j.Iom_jObject;
import ch.interlis.iox_j.EndBasketEvent;
import ch.interlis.iox_j.EndTransferEvent;
import ch.interlis.iox_j.ObjectEvent;
import ch.interlis.iox_j.StartBasketEvent;
import ch.interlis.iox_j.StartTransferEvent;
import ch.interlis.iox_j.logging.LogEventFactory;

public class Datatypes10Test {

	private TransferDescription td=null;
	
	@Before
	public void setUp() throws Exception {
		// ili-datei lesen
		Configuration ili1cConfig=new Configuration();
		FileEntry fileEntry=new FileEntry("src/test/data/validator/Datatypes10.ili", FileEntryKind.ILIMODELFILE);
		ili1cConfig.addFileEntry(fileEntry);
		td=ch.interlis.ili2c.Ili2c.runCompiler(ili1cConfig);
		assertNotNull(td);
	}

	//############################################################/
	//########## SUCCESSFUL TESTS ################################/
	//############################################################/
	////////////////// START Text /////////////////////////////////
	@Test
	public void textMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text", "aabbccddee");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void textMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text", "a");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void text2Alphabetica_zA_Z(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	@Test
	public void text2Numeric0_9(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "0123456789");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	@Test
	public void text2Val(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "NUL ETX DEL ESC SP");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	@Test
	public void text2Signs(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "{|}~`_^][\\@?<=>;:/.-,+*()'&%$#\"!");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	@Test
	public void text2WordSeparation(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "I_am_the_2_Test");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	@Test
	public void text2ZeichensatzContent(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text2", "�����������������������������");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Text ///////////////////////////////////	
	////////////////// START Bereich //////////////////////////////
	// Dezimal 9.9 wird gerundet auf (10.0).
	// 10.4 gerundet = 10. valid.
	// 10.5 gerundet = 11. unvalid.
	@Test
	public void bereichMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	// Dezimal 0.0 wird gerundet auf (0).
	// -0.4 gerundet =  0. valid.
	// -0.5 gerundet = -1. unvalid.
	@Test
	public void bereichMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich", "-0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void bereich2Maximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich2", "10.499");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void bereich2Minimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich2", "-0.499");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Bereich ////////////////////////////////	
	////////////////// START Aufzaehlung //////////////////////////
	@Test
	public void aufzaehlungMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlung", "mehr.zehn");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void aufzaehlungMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlung", "null");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void aufzaehlungVerschachtelung(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlungVerschachtelung", "null.eins.zwei.drei.vier.fuenf");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Aufzaehlung ////////////////////////////	
	////////////////// START Laenge ///////////////////////////////
	@Test
	public void laengeMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void laengeMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void laenge2ThirdPositionAfterDot(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge2", "1000.999");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Laenge /////////////////////////////////	
	////////////////// START Flaechenmass /////////////////////////
	@Test
	public void flaecheMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void flaecheMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void flaeche2ThirdPositionAfterDot(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche2", "99.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Flaechenmass ///////////////////////////
	////////////////// START Winkel ///////////////////////////////
	@Test
	public void winkelRadianMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void winkelRadianMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void winkelGradsMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("grads", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void winkelGradsMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("grads", "0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void winkelDegreesMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("degrees", "10.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void winkelDegreesMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("degrees", "0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	////////////////// END Winkel /////////////////////////////////
	////////////////// START Datum ////////////////////////////////
	@Test
	public void datumLowestYear(){
		Iom_jObject objLowestYear=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objLowestYear.setattrvalue("datum", "15821225");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objLowestYear));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void datumHighestYear(){
		Iom_jObject objHighestYear=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestYear.setattrvalue("datum", "29991225");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestYear));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void datumLowestMonth(){
		Iom_jObject objLowestMonth=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objLowestMonth.setattrvalue("datum", "20160125");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objLowestMonth));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void datumHighestMonth(){
		Iom_jObject objHighestMonth=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestMonth.setattrvalue("datum", "20161225");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestMonth));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void datumLowestDay(){
		Iom_jObject objLowestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objLowestDay.setattrvalue("datum", "20161201");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objLowestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void datumHighestDay(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("datum", "20161231");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Datum //////////////////////////////////
	////////////////// START HorizAlignment ///////////////////////
	@Test
	public void horizAlignmentLeft(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("horizAlignment", "Left");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void horizAlignmentCenter(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("horizAlignment", "Center");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void horizAlignmentRight(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("horizAlignment", "Right");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END HorizAlignment /////////////////////////
	////////////////// START VertAlignment ////////////////////////
	@Test
	public void vertAlignmentTop(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Top");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void vertAlignmentCap(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Cap");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void vertAlignmentHalf(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Half");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void vertAlignmentBase(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Base");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void vertAlignmentBottom(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Bottom");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END VertAlignment //////////////////////////
	////////////////// START Koord2 ///////////////////////////////
	@Test
	public void koord2Ok(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("koord2", "5.55 200.6");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void koord2UOk(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("koord2", "@");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	////////////////// END Koord2 /////////////////////////////////	
	////////////////// START Koord3 ///////////////////////////////
	@Test
	public void koord3Ok(){
		Iom_jObject objSuccessFormat=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objSuccessFormat.setattrvalue("koord3", "5.55, 200.6 9999");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSuccessFormat));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void koord3UOk(){
		Iom_jObject objSuccessFormat=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objSuccessFormat.setattrvalue("koord3", "@");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSuccessFormat));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Koord3 /////////////////////////////////	
	////////////////// START Linientyp ////////////////////////////
	@Test
	public void polylineTypeStraights2dOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("straights2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordStart=segments.addattrobj("segment", "COORD");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		coordEnd.setattrvalue("C1", "480001.000");
		coordEnd.setattrvalue("C2", "70001.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void polylineTypeStraights3dOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("straights3d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordStart=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		coordStart.setattrvalue("C3", "4000.000");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordEnd.setattrvalue("C1", "480000.000");
		coordEnd.setattrvalue("C2", "70000.000");
		coordEnd.setattrvalue("C3", "4000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void polylineTypeSTRAIGHTSARCS2DOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("straightsarcs2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480000.000");
		endSegment.setattrvalue("C2", "70000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void polylineTypeSTRAIGHTSARCS3DOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("straightsarcs3d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject secondSegment=segments.addattrobj("segment", "COORD");
		secondSegment.setattrvalue("C1", "480000.000");
		secondSegment.setattrvalue("C2", "70000.000");
		secondSegment.setattrvalue("C3", "5000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		arcSegment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void polylineTypeARCS2DOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("arcs2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void polylineTypeARCS3DOk(){
		Iom_jObject objStraightsSuccess=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsSuccess.addattrobj("arcs3d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		arcSegment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Linientyp //////////////////////////////
	
	////////////////// START LinientypWithoutOverlaps /////////////
	// Wird noch von Claude im Valdator erstellt.
	////////////////// END LinientypWithoutOverlaps ///////////////
	
	////////////////// START FlaechentypSurface ///////////////////
	@Test
	public void surfaceTypeSurface1Boundary2DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurface2Boundaries2DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		// outer boundary
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		// inner boundary
		IomObject innerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue2 = innerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments2=polylineValue2.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment2=segments2.addattrobj("segment", "COORD");
		startSegment2.setattrvalue("C1", "480000.000");
		startSegment2.setattrvalue("C2", "70000.000");
		IomObject endSegment2=segments2.addattrobj("segment", "COORD");
		endSegment2.setattrvalue("C1", "480001.000");
		endSegment2.setattrvalue("C2", "70001.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurface2Polylines2DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline 1
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		// polyline 2
		IomObject polylineValue11 = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments11=polylineValue11.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment11=segments11.addattrobj("segment", "COORD");
		startSegment11.setattrvalue("C1", "480000.000");
		startSegment11.setattrvalue("C2", "70000.000");
		IomObject endSegment11=segments11.addattrobj("segment", "COORD");
		endSegment11.setattrvalue("C1", "480001.000");
		endSegment11.setattrvalue("C2", "70001.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurfaceWithArc2DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		// Arc
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurface1Boundary3DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		endSegment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurface2Boundaries3DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		// outer boundary
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		endSegment.setattrvalue("C3", "5000.000");
		// inner boundary
		IomObject innerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		IomObject polylineValue2 = innerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments2=polylineValue2.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment2=segments2.addattrobj("segment", "COORD");
		startSegment2.setattrvalue("C1", "480000.000");
		startSegment2.setattrvalue("C2", "70000.000");
		startSegment2.setattrvalue("C3", "5000.000");
		IomObject endSegment2=segments2.addattrobj("segment", "COORD");
		endSegment2.setattrvalue("C1", "480001.000");
		endSegment2.setattrvalue("C2", "70001.000");
		endSegment2.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurface2Polylines3DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline 1
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		endSegment.setattrvalue("C3", "5000.000");
		// polyline 2
		IomObject polylineValue11 = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments11=polylineValue11.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment11=segments11.addattrobj("segment", "COORD");
		startSegment11.setattrvalue("C1", "480000.000");
		startSegment11.setattrvalue("C2", "70000.000");
		startSegment11.setattrvalue("C3", "5000.000");
		IomObject endSegment11=segments11.addattrobj("segment", "COORD");
		endSegment11.setattrvalue("C1", "480001.000");
		endSegment11.setattrvalue("C2", "70001.000");
		endSegment11.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	@Test
	public void surfaceTypeSurfaceWithArc3DOk(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		startSegment.setattrvalue("C3", "5000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480001.000");
		endSegment.setattrvalue("C2", "70001.000");
		endSegment.setattrvalue("C3", "5000.000");
		// Arc
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		arcSegment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END FlaechentypSurface /////////////////////
	
	////////////////// START FlaechentypSurfaceWithoutOverlap /////
	// Wird noch von Claude im Valdator erstellt.
	////////////////// END FlaechentypSurfaceWithoutOverlap ///////
	
	////////////////// START AreaWithoutOverlaps //////////////////
	// Wird noch von Claude im Valdator erstellt.
	////////////////// END AreaWithoutOverlaps ////////////////////
	
	//############################################################/
	//########## FAILING TESTS ###################################/
	//############################################################/
	//////////////////START Text /////////////////////////////////
	@Test
	public void textGreaterThanMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text", "aabbccddeef");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("Attribute text is length restricted to 10", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void textUnknownProperty(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("Ztext", "a");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unknown property <Ztext>", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void textContainUnvalidCharacters(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("text", "\n\t");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("Attribute text must not contain control characters", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Text ///////////////////////////////////	
	////////////////// START Bereich //////////////////////////////
	@Test
	public void bereichContainLetters(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich", "test");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <test> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void bereichGreaterThanMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void bereichLessThanMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich", "-0.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value -0.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void bereich2GreaterThanMaximum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich2", "10.500");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.500 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void bereich2LessThanMinimum(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("bereich2", "-0.500");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value -0.500 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Bereich ////////////////////////////////	
	////////////////// START Aufzaehlung //////////////////////////
	@Test
	public void aufzaehlungInvalidHierarchicalLevel(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlung", "mehr.mehr.vier");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value mehr.mehr.vier is not a member of the enumeration", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void aufzaehlungNotTypeOfEnumeration(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaelung", "eins");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unknown property <aufzaelung>", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void aufzaehlungNotInSameEnumeration(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlung2Oberauszaehlungen", "meter.ml");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value meter.ml is not a member of the enumeration", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void aufzaehlungNotInSameEnumeration2(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("aufzaehlung2Oberauszaehlungen", "liter.mm");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value liter.mm is not a member of the enumeration", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Aufzaehlung ////////////////////////////	
	////////////////// START Laenge ///////////////////////////////
	@Test
	public void laengeToHigh(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void laengeToLow(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 0.4 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void laengeNotValid(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "abc");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <abc> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void laengeWith2Dez(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("laenge", "2.0 5.2");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <2.0 5.2> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Laenge /////////////////////////////////	
	////////////////// START Flaechenmass /////////////////////////
	@Test
	public void flaecheToHigh(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void flaecheToLow(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 0.4 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void flaecheNotValid(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "abc");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <abc> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void FlaecheWith2Dez(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("flaeche", "2.0 5.2");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <2.0 5.2> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Flaechenmass ///////////////////////////	
	////////////////// START Winkel ///////////////////////////////
	@Test
	public void radiansGreaterThanMax(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void radiansLessThanMin(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 0.4 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void gradsGreaterThanMax(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("grads", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void gradsLessThanMin(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("grads", "0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 0.4 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void degreesGreaterThanMax(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("degrees", "10.5");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 10.5 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void degreesLessThanMin(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("degrees", "0.4");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value 0.4 is out of range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void winkelTypeNotValid(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "abc");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <abc> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void winkelNotValidR(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("radians", "1.5 5.2");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <1.5 5.2> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void winkelNotValidG(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("grads", "1.5 5.2");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <1.5 5.2> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void winkelNotValidD(){
		Iom_jObject objTest=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objTest.setattrvalue("degrees", "1.5 5.2");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objTest));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <1.5 5.2> is not a number", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Winkel /////////////////////////////////	
	////////////////// START Datum ////////////////////////////////
	@Test
	public void datumYearToLow(){
		Iom_jObject objYearToLow=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objYearToLow.setattrvalue("datum", "15801225");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objYearToLow));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <15801225> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumYearToHigh(){
		Iom_jObject objYearToHigh=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objYearToHigh.setattrvalue("datum", "30001225");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objYearToHigh));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
				assertTrue(logger.getErrs().size()==1);
		assertEquals("value <30001225> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumMonthToLow(){
		Iom_jObject objMonthToLow=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objMonthToLow.setattrvalue("datum", "20160025");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objMonthToLow));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <20160025> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumMonthToHigh(){
		Iom_jObject objMonthToHigh=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objMonthToHigh.setattrvalue("datum", "20161325");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objMonthToHigh));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <20161325> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumDayToLow(){
		Iom_jObject objDayToLow=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objDayToLow.setattrvalue("datum", "20161200");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objDayToLow));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <20161200> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumDayToHigh(){
		Iom_jObject objDayToHigh=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objDayToHigh.setattrvalue("datum", "20161232");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objDayToHigh));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <20161232> is not in range", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumFormatWithDots(){
		Iom_jObject objFormatWithDots=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objFormatWithDots.setattrvalue("datum", "2016.12.25");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objFormatWithDots));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <2016.12.25> is not a valid Date", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumLengthToShort(){
		Iom_jObject objLengthToShort=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objLengthToShort.setattrvalue("datum", "2016125");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objLengthToShort));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <2016125> is not a valid Date", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void datumLengthToHigh(){
		Iom_jObject objLengthToLong=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objLengthToLong.setattrvalue("datum", "201612251");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objLengthToLong));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value <201612251> is not a valid Date", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Datum //////////////////////////////////
	////////////////// START HorizAlignment ///////////////////////
	@Test
	public void horizAlignmentNotTypeOfEnumeration(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("horizAlignment", "Top");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value Top is not a member of the enumeration", logger.getErrs().get(0).getEventMsg());
	}
	
	////////////////// END HorizAlignment /////////////////////////
	////////////////// START VertAlignment ////////////////////////
	@Test
	public void vertAlignmentNotTypeOfEnumeration(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("vertAlignment", "Left");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("value Left is not a member of the enumeration", logger.getErrs().get(0).getEventMsg());
	}
	
	////////////////// END VertAlignment //////////////////////////
	////////////////// START Koord2 ///////////////////////////////
	@Test
	public void koord2WrongDimensions(){
		Iom_jObject objHighestDay=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objHighestDay.setattrvalue("koord2", "5.55 200.6 9999");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objHighestDay));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	
	////////////////// END Koord2 /////////////////////////////////	
	////////////////// START Koord3 ///////////////////////////////
	@Test
	public void koord3WrongDimensions(){
		Iom_jObject objSuccessFormat=new Iom_jObject("Datatypes10.Topic.Table", "o1");
		objSuccessFormat.setattrvalue("koord3", "5.55, 200.6");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSuccessFormat));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==0);
	}
	////////////////// END Koord3 /////////////////////////////////
	////////////////// START Linientyp ////////////////////////////
	@Test
	public void polylineTypeAlineDoesNotContainTypePolyline(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("straights2d", "LINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordStart=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordEnd.setattrvalue("C1", "480000.000");
		coordEnd.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected Type LINE; POLYLINE expected", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void polylineTypeSequenceDoesNotContainTypeSegments(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("straights2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "COORD");
		IomObject coordStart=segments.addattrobj("segment", "COORD");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordEnd.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		coordEnd.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected Type COORD", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void polylineTypeSegmentDoesNotContainTypeCoordOrArc(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("straights2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordStart=segments.addattrobj("segment", "POLYLINE");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordEnd.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		coordEnd.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected Type POLYLINE", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void polylineTypeIOMCompleteWith2Sequences(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("straights2d", "POLYLINE");
		polylineValue.setobjectconsistency(IomConstants.IOM_COMPLETE);
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject segment2=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordStart=segments.addattrobj("segment", "COORD");
		IomObject coordEnd=segments.addattrobj("segment", "COORD");
		coordStart.setattrvalue("C1", "480000.000");
		coordEnd.setattrvalue("C1", "480000.000");
		coordStart.setattrvalue("C2", "70000.000");
		coordEnd.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("invalid number of sequences in COMPLETE basket", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void polylineTypeUnexpectedARC(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("straightsarcs2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480000.000");
		endSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected ARC", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void polylineTypeUnexpectedCOORD(){
		Iom_jObject objStraightsFail=new Iom_jObject("Datatypes10.Topic.LineTable", "o1");
		IomObject polylineValue=objStraightsFail.addattrobj("arcs2d", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject startSegment=segments.addattrobj("segment", "COORD");
		startSegment.setattrvalue("C1", "480000.000");
		startSegment.setattrvalue("C2", "70000.000");
		IomObject endSegment=segments.addattrobj("segment", "COORD");
		endSegment.setattrvalue("C1", "480000.000");
		endSegment.setattrvalue("C2", "70000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "480000.000");
		arcSegment.setattrvalue("A2", "300000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objStraightsFail));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected COORD", logger.getErrs().get(0).getEventMsg());
	}
	////////////////// END Linientyp //////////////////////////////	
	////////////////// START LinientypWithoutOverlaps /////////////
	
	// Wird noch von Claude im Valdator erstellt.
	
	////////////////// END LinientypWithoutOverlaps ///////////////
	////////////////// START FlaechentypSurface ///////////////////
	@Test
	public void surfaceTypeNotTypeMULTISURFACE(){
		Iom_jObject objNotMultisurface=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject surfaceValue=objNotMultisurface.addattrobj("surface2d", "SURFACE");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objNotMultisurface));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("unexpected Type SURFACE; MULTISURFACE expected", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void surfaceTypeCompleteAndTwoSurfaces(){
		Iom_jObject objCompleteMultisurface=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objCompleteMultisurface.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_COMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject surfaceValue2 = multisurfaceValue.addattrobj("surface", "SURFACE");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objCompleteMultisurface));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("invalid number of surfaces in COMPLETE basket", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void surface2dWith3dImplementation(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject segment=segments.addattrobj("segment", "COORD");
		segment.setattrvalue("C1", "480000.000");
		segment.setattrvalue("C2", "70000.000");
		segment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("Wrong COORD structure, C3 not expected", logger.getErrs().get(0).getEventMsg());
	}
	
	@Test
	public void surface3dWith2dImplementation(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject segment=segments.addattrobj("segment", "COORD");
		segment.setattrvalue("C1", "480000.000");
		segment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==1);
		assertEquals("Wrong COORD structure, C3 expected", logger.getErrs().get(0).getEventMsg());
	}
	@Test
	public void surface3dInvalidValueRange(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject segment=segments.addattrobj("segment", "COORD");
		segment.setattrvalue("C1", "4800000.000");
		segment.setattrvalue("C2", "700000.000");
		segment.setattrvalue("C3", "50000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==3);
		assertEquals("value 4800000.000 is out of range", logger.getErrs().get(0).getEventMsg());
		assertEquals("value 700000.000 is out of range", logger.getErrs().get(1).getEventMsg());
		assertEquals("value 50000.000 is out of range", logger.getErrs().get(2).getEventMsg());
	}
	
	@Test
	public void surface2dInvalidValueRange(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordSegment=segments.addattrobj("segment", "COORD");
		coordSegment.setattrvalue("C1", "4800000.000");
		coordSegment.setattrvalue("C2", "700000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==2);
		assertEquals("value 4800000.000 is out of range", logger.getErrs().get(0).getEventMsg());
		assertEquals("value 700000.000 is out of range", logger.getErrs().get(1).getEventMsg());
	}
	@Test
	public void surface3dWithARCInvalidValueRange(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface3d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject segment=segments.addattrobj("segment", "COORD");
		segment.setattrvalue("C1", "480000.000");
		segment.setattrvalue("C2", "70000.000");
		segment.setattrvalue("C3", "5000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "4800000.000");
		arcSegment.setattrvalue("A2", "700000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		arcSegment.setattrvalue("C3", "5000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==2);
		assertEquals("value 4800000.000 is out of range", logger.getErrs().get(0).getEventMsg());
		assertEquals("value 700000.000 is out of range", logger.getErrs().get(1).getEventMsg());
	}
	
	@Test
	public void surface2dWithARCInvalidValueRange(){
		Iom_jObject objSurfaceSuccess=new Iom_jObject("Datatypes10.Topic.FlaechenTable", "o1");
		IomObject multisurfaceValue=objSurfaceSuccess.addattrobj("surface2d", "MULTISURFACE");
		multisurfaceValue.setobjectconsistency(IomConstants.IOM_INCOMPLETE);
		IomObject surfaceValue = multisurfaceValue.addattrobj("surface", "SURFACE");
		IomObject outerBoundary = surfaceValue.addattrobj("boundary", "BOUNDARY");
		// polyline
		IomObject polylineValue = outerBoundary.addattrobj("polyline", "POLYLINE");
		IomObject segments=polylineValue.addattrobj("sequence", "SEGMENTS");
		IomObject coordSegment=segments.addattrobj("segment", "COORD");
		coordSegment.setattrvalue("C1", "480000.000");
		coordSegment.setattrvalue("C2", "70000.000");
		IomObject arcSegment=segments.addattrobj("segment", "ARC");
		arcSegment.setattrvalue("A1", "4800000.000");
		arcSegment.setattrvalue("A2", "700000.000");
		arcSegment.setattrvalue("C1", "480000.000");
		arcSegment.setattrvalue("C2", "70000.000");
		ValidationConfig modelConfig=new ValidationConfig();
		LogCollector logger=new LogCollector();
		LogEventFactory errFactory=new LogEventFactory();
		Settings settings=new Settings();
		Validator validator=new Validator(td, modelConfig,logger,errFactory,settings);
		validator.validate(new StartTransferEvent());
		validator.validate(new StartBasketEvent("Datatypes10.Topic","b1"));
		validator.validate(new ObjectEvent(objSurfaceSuccess));
		validator.validate(new EndBasketEvent());
		validator.validate(new EndTransferEvent());
		// Asserts
		assertTrue(logger.getErrs().size()==2);
		assertEquals("value 4800000.000 is out of range", logger.getErrs().get(0).getEventMsg());
		assertEquals("value 700000.000 is out of range", logger.getErrs().get(1).getEventMsg());
	}
	////////////////// END FlaechentypSurface /////////////////////	
	////////////////// START FlaechentypSurfaceWithoutOverlap /////
	
	// Wird noch von Claude im Valdator erstellt.
	
	////////////////// END FlaechentypSurfaceWithoutOverlap ///////	
	////////////////// START AreaWithoutOverlaps //////////////////
	
	// Wird noch von Claude im Valdator erstellt.
	
	////////////////// END AreaWithoutOverlaps ////////////////////
}