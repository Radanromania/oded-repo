/**
 * 
 */
package il.fmr.coord.test;

import static org.junit.Assert.*;
import il.co.fmr.coord.service.JsonConverter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


/**
 * @author oded
 *
 */
public class JsonConverterTest {

	@Test
	public void testFromMap() {
		HashMap<String,String > map = new HashMap<String,String>();
		
		map.put("p1", "v1");
		map.put("p2", "v2");
		
		try {
			String json = JsonConverter.fromMap(map);
			Map<String,String > map2 = JsonConverter.toMap(json);
			
			assertEquals(map.get("p1"), map2.get("p1"));
			assertEquals(map.get("p2"), map2.get("p2"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		
		
	}

	
	@Test
	public void testToMap() {
		
		String json = "{\"p1\":\"v1\",\"p2\":\"v2\"}";
		
		try {
			Map<String,String > map = JsonConverter.toMap(json);
			String json2 = JsonConverter.fromMap(map);
			assertEquals(json,json2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		
		
	}
}
