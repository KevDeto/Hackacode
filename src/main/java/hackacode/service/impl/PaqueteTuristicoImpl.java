package hackacode.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hackacode.model.dao.IPaqueteTuristicoDao;
import hackacode.model.dto.PaqueteTuristicoDto;
import hackacode.model.entity.PaqueteTuristico;
import hackacode.model.entity.ServicioTuristico;
import hackacode.service.IPaqueteTuristicoService;
import hackacode.utils.RelacionadorServicios;

@Service
public class PaqueteTuristicoImpl implements IPaqueteTuristicoService{

    @Autowired
    private IPaqueteTuristicoDao paqueteTuristicoDao;
    @Autowired
    private RelacionadorServicios relacionadorServicios;

    @Transactional
    @Override
    public PaqueteTuristico save(PaqueteTuristicoDto paqueteTuristicoDto) {
    	
    	Set<ServicioTuristico> servicios = relacionadorServicios
    			.obtenerServiciosRelacionados(paqueteTuristicoDto.getServicio_turistico());

        PaqueteTuristico paqueteTuristico = PaqueteTuristico.builder()
            .UUID(paqueteTuristicoDto.getUUID())
            .costo_paquete(paqueteTuristicoDto.getCosto_paquete())
            .servicios(servicios) // Relación opcional
            .build();

        return paqueteTuristicoDao.save(paqueteTuristico);
    }
    
    @Transactional(readOnly = true)
    @Override
    public PaqueteTuristico findById(Long id) {
        return paqueteTuristicoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(PaqueteTuristico paqueteTuristico) {
        paqueteTuristicoDao.delete(paqueteTuristico);
    }

    @Override
    public boolean existsById(Long id) {
        return paqueteTuristicoDao.existsById(id);
    }

    @Override
    public List<PaqueteTuristico> listAll() {
        return (List<PaqueteTuristico>)paqueteTuristicoDao.findAll();
    }
}