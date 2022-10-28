package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.CitizenApp;

public interface CitizenAppRepo extends JpaRepository<CitizenApp, Serializable>{

}
