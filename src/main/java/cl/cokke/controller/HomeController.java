package cl.cokke.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String Main(Model modelo) {
	
		String noticias = "src/main/resources/static/noticias.txt";
		ArrayList<String> p = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(noticias);
			BufferedReader br = new BufferedReader(fr); 
			String data = br.readLine();
			
			
			while(data !=null) {
				String[] arregloNoticia = data.split("@@");
				p.add(arregloNoticia[0]);
				p.add(arregloNoticia[1]);
				p.add(arregloNoticia[2]);
				logger.info("Agregada la noticia  "+ data + ": ");
				data = br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			logger.error("Error leyendo el fichero "+ noticias + ": " + e);
		}
		modelo.addAttribute("titulo1",p.get(0));
		modelo.addAttribute("desc1",p.get(1));
		modelo.addAttribute("img01", p.get(2));
		modelo.addAttribute("titulo2", p.get(3));
		modelo.addAttribute("desc2", p.get(4));
		modelo.addAttribute("img02", p.get(5));
		modelo.addAttribute("titulo3", p.get(6));
		modelo.addAttribute("desc3", p.get(7));
		modelo.addAttribute("img03", p.get(8));
		modelo.addAttribute("titulo4", p.get(9));
		modelo.addAttribute("desc4", p.get(10));
		modelo.addAttribute("img04", p.get(11));
		modelo.addAttribute("titulo5", p.get(12));
		modelo.addAttribute("desc5", p.get(13));
		modelo.addAttribute("img05", p.get(14));
		
		
		return "main";
	}

}
