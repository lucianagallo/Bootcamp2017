package main.java.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.dao.ClimaDiaDAO;
import main.java.entity.ClimaDia;
import main.java.entity.ClimaDiaBuilder;

@RestController
@RequestMapping(value="clima")
public class DiaController {

	@Autowired
	ClimaDiaDAO diaDao;	
	private HttpServletResponse httpResponse;

	@RequestMapping(value= "/dias", method = RequestMethod.GET, produces= "application/json")
    public ResponseEntity<List<ClimaDia>> getAllClimaDia() throws ParseException {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-mm-yyyy");
		String strFecha1 = "27-04-2017";
		Date fecha1 = formatoDelTexto.parse(strFecha1);
		final List<ClimaDia> dias = new ArrayList<>();
        try {
        	dias.add(new ClimaDiaBuilder().withCodigo(30).withFecha(fecha1).withDia("Jue").withMax(38).withMin(27)
    				.withDescripcion("Parcialmente nublado").build());
        } catch (final Exception ex) {
        }
        return new ResponseEntity<List<ClimaDia>>(dias, HttpStatus.OK);
	}

	@RequestMapping(value= "test", method = RequestMethod.GET)
	public ResponseEntity<String> test(){
	   return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

	@RequestMapping(value = "/savedia", method = RequestMethod.POST)
	public ResponseEntity<ClimaDia> saveClimaDia(@RequestBody ClimaDia cd) throws IOException {
		if (cd == null)
			httpResponse.sendError(HttpStatus.CONFLICT.value(), "Usuario no valido");
		else {
			diaDao.insert(cd);
		}
		return new ResponseEntity<ClimaDia>(cd, HttpStatus.OK);
	}

	@RequestMapping(value = "/updatedia", method = RequestMethod.PUT)
	public ResponseEntity<ClimaDia> updateClimaDia(@RequestBody ClimaDia cd) throws IOException {
		if (cd == null)
			httpResponse.sendError(HttpStatus.CONFLICT.value(), "Usuario no existente");
		else {
			diaDao.update(cd);
		}
		return new ResponseEntity<ClimaDia>(cd, HttpStatus.OK);
	}
}