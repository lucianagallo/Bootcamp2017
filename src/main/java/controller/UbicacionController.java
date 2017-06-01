//package main.java.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import main.java.dao.UbicacionDAO;
//import main.java.entity.Ubicacion;
//
//@RestController
//@RequestMapping("ubicacion")
//public class UbicacionController{
//		
//	    @Autowired
//	    @Qualifier("ubicacionDAO")
//	    private UbicacionDAO ubicacion;
//
//
//	    @RequestMapping
//	    public ResponseEntity<List<Ubicacion>> getUbicacion(){
//	        return new ResponseEntity<List<Ubicacion>>((List<Ubicacion>)(Object)ubicacion.selectAll(), HttpStatus.OK);
//	    }
////	    
////	    @RequestMapping(value="/{country}/{zone}/{city}", method = RequestMethod.GET)
////	    public ResponseEntity<Ubicacion> getUbicacion(@PathVariable("country") String country,@PathVariable("zone") String zone,@PathVariable("city") String city){
////	    	return new ResponseEntity<Ubicacion>(ubicacion.select(UbicacionBuilder.withPais(country).withRegion(zone).withCiudad(city).build()), HttpStatus.OK) ;
////	    }
//	    @RequestMapping(value="/add", method = RequestMethod.POST,  headers = {"content-type=application/json"})
//	    public ResponseEntity<Ubicacion> postUbicacion(@RequestBody Ubicacion ubicacion){
//	        this.ubicacion.insert(ubicacion);
//	        return new ResponseEntity<Ubicacion>(ubicacion, HttpStatus.OK);
//	    }
//}

