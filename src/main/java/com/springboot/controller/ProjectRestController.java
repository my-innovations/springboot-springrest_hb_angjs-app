package com.springboot.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.OfficeLocation;
import com.springboot.entity.Project;
import com.springboot.model.ProjectModel;
import com.springboot.model.Response;
import com.springboot.service.ProjectService;

@RestController
public class ProjectRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/postproject", method = RequestMethod.POST)

	public void postProject(@RequestBody ProjectModel p) {

		log.debug("Inside postProject():");

		OfficeLocation o1 = new OfficeLocation();
		o1.setOfficeLocation(p.getLoc1());

		OfficeLocation o2 = new OfficeLocation();
		o2.setOfficeLocation(p.getLoc2());

		// donot enter duplicate office locations to office table -- check here

		Set<OfficeLocation> locations = new HashSet<>();
		locations.add(o1);
		locations.add(o2);

		Project project = new Project();
		project.setProjectName(p.getProjectname());
		project.setOffices(locations);

		projectService.saveProject(project);
	}

	@RequestMapping(value = "/postOffice", method = RequestMethod.POST)
	public Response createOffice(@RequestBody OfficeLocation office) {
		System.out.println(office);
		Long id = projectService.saveOffice(office);
		if (id == null)
			return new Response("Failed", "Pleaase choose a different name for Office");
		else
			return new Response("Success", "Office Created with id:" + id);

	}

	@RequestMapping("/findallProjects")
	public Response findAll() {
		List<Project> projects = projectService.getAllProjects();
		log.debug("projects:" + projects);
		return new Response("Done", projects);
	}

	@RequestMapping("/project/{id}")
	public Response getProjectById(@PathVariable("projid") long projid) {
		Project p = projectService.getProjectById(projid);
		return new Response("Done", p);
	}

	@RequestMapping("/findProjectsbyLocation")
	public Response getProjecstByLocation(@RequestParam("location") String location) {
		List<Project> Projects = projectService.getProjectsByLocation(location);
		return new Response("Done", Projects);
	}

}
