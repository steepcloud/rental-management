package net.custom.rentals.management.service;

import net.custom.rentals.management.model.Tenant;
import net.custom.rentals.management.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }
    
    @Transactional(readOnly = true)
    public Optional<Tenant> findByEmail(String email) {
        return tenantRepository.findByEmail(email);
    }
    
    @Transactional(readOnly = true)
    public List<Tenant> findByNameContaining(String name) {
        return tenantRepository.findByNameContaining(name);
    }

    // public List<Tenant> findActiveTenants() {
    //    return tenantRepository.findActiveTenants();
    // }

    //public Tenant getTenantById(Long id) {
    //    Optional<Tenant> tenant = tenantRepository.findById(id);
    //    return tenant.orElse(null);
    //}
    
    @Transactional(readOnly = true)
    public Optional<Tenant> getTenantById(Long tenantId) {
        return tenantRepository.findById(tenantId);
    }
    
    @Transactional(readOnly = true)
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Tenant getTenantInfo(String email) {
    	Optional<Tenant> tenant = tenantRepository.findByEmail(email);
    	return tenant.orElse(null);
    }
    
    @Transactional
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }
    
    @Transactional
    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
}
