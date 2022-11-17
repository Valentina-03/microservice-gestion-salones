package com.springboot.app.gestionsalones.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.springboot.app.gestionsalones.services.VariedadesService;

@Service
public class VariedadesServiceImpl implements VariedadesService
{

	@Override
	public List<String> getSalones(String json) 
	{
		List<String> salones = new ArrayList<>();
		JSONArray array = new JSONArray(json);
		for(int i = 0; i<array.length(); i++) {
			Gson gson = new Gson();
			Properties properties = gson.fromJson(String.valueOf(array.get(i)), Properties.class);
			salones.add(properties.getProperty("id_salon"));
		}
		return salones;
	}

	@Override
	public int getEstadoSalon(String json) {
		JSONObject obj = new JSONObject(json);
        return Integer.parseInt(obj.get("estado").toString());
	}

	@Override
	public List<String> getBloques(String json) {
		List<String> bloques = new ArrayList<>();
		JSONArray array = new JSONArray(json);
		for(int i = 0; i<array.length(); i++) {
			Gson gson = new Gson();
			Properties properties = gson.fromJson(String.valueOf(array.get(i)), Properties.class);
			bloques.add(properties.getProperty("nombre"));
		}
		return bloques;
	}

	@Override
	public List<String> getUser(String json) {
		List<String> dates = new ArrayList<>();
		JSONObject obj = new JSONObject(json);
        dates.add(obj.get("nombre").toString());
        dates.add(obj.get("email").toString());
		return dates;
	}
	
}