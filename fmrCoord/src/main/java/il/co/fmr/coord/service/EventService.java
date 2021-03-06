/**
 * 
 */
package il.co.fmr.coord.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import il.co.fmr.coord.app.FaasException;
import il.co.fmr.coord.rest.FaasEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author oded
 *
 */

@Service
public class EventService {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	
	/**
	 * empty constructor
	 */
	public EventService()
	{
		
	}
	
	/**
	 * 
	 * @param event FaasEvent to create
	 */
	public void createEvent(FaasEvent event)
	{
		String query = "INSERT INTO FAAS_EVENTS (event_type,event_source,event_time,data) values ( ? ,?,?,to_json(?::json) )";
		String json;
		try {
			json = JsonConverter.fromMap(event.getParams());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new FaasException();
		}
		jdbcTemplate.update(query,event.getEventType(),event.getEventSource(),event.getEventTime(),json);
	}
	
	
	/**
	 * find an event by id.
	 * @param id the event id
	 * @return FaasEvent
	 */
	public FaasEvent findById(int id)
	{
		String query = "SELECT * FROM FAAS_EVENTS where id=?";
		
		FaasEvent event = jdbcTemplate.queryForObject(query, new Object[] {id}, new RowMapper<FaasEvent>() {
			@Override
			public FaasEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
				FaasEvent event = new FaasEvent();
				event.setId(rs.getInt("ID"));
				event.setEventType(rs.getString("EVENT_TYPE"));
				event.setEventSource(rs.getString("EVENT_SOURCE"));
				event.setEventTime(rs.getDate("EVENT_TIME"));
				String json = rs.getString("DATA");
				try {
					event.setParams(JsonConverter.toMap(json));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new FaasException();
				}
				return (event);
			}
		});
		return(event);
	}
	
	/**
	 * find all events by type
	 * @param eventType the event type
	 * @return List of FaasEvent objects
	 */
	public List<FaasEvent> findbyType(String eventType)
	{
		String query = "SELECT * FROM FAAS_EVENTS where event_type=?";
		
		List<FaasEvent> events = jdbcTemplate.query(query, new Object[] {eventType}, new FaasEventMapper());
		return(events);
		
		
	}
	
	
	
	
}
