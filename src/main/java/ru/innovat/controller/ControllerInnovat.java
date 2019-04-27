package ru.innovat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innovat.models.Event;
import ru.innovat.models.Organization;
import ru.innovat.models.Person;
import ru.innovat.models.Project;
import ru.innovat.models.*;
import ru.innovat.service.*;
import ru.innovat.service.search.SearchPerson;


import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@org.springframework.stereotype.Controller    // This means that this class is a Controller
public class ControllerInnovat {
    @Autowired
    private PersonService personService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EventService eventService;
    @Autowired
    private OrganizationSevice organizationService;
    @Autowired
    private SearchPerson searchPerson;

    @RequestMapping(value = "/menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping(value = "/person")
        public String listPerson(String q, Model model) {
            List searchResults = null;
            try {
                searchResults = searchPerson.fuzzySearch(q);
            }
            catch (Exception ex) {
                // here you should handle unexpected errors
                // ...
                // throw ex;
            }
            model.addAttribute("searchResults", searchResults);
        return "person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.GET)
    public String getAddPerson(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        personService.addPerson(person);
        return "redirect:/person/" + person.getId_person();
    }

    @GetMapping("person/{id}/delete")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        personService.deletePerson(id);
        return "redirect:/person";
    }


    @GetMapping("person/{id}")
    public String onePerson(@PathVariable("id") int id, Model model){
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "onePerson";
    }


    @RequestMapping(value = "/project")
    public String listProject(Model model) {
        Iterable<Project> list = projectService.projectList();
        model.addAttribute("projectList", list);
        return "project";
    }

    @GetMapping("/project/{id}/delete")
    public String deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.GET)
    public String getAddProject(Model model) {

        model.addAttribute("project", new Project());
        return "addproject";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute Project project, Model model) {
        model.addAttribute("project", project);
        projectService.addProject(project);
        return "redirect:/project/" + project.getId_project();
    }



    @GetMapping("project/{id}")
    public String oneProject(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", projectService.findProject(id));
        return "oneProject";
    }

    @RequestMapping(value = "/event")
    public String listEvent(Model model) {
        List<Event> list = eventService.eventList();
        model.addAttribute("eventList", list);
        return "event";
    }

    @RequestMapping(value = "/event/add", method = RequestMethod.GET)
    public String getAddEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addevent";
    }

    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        eventService.addEvent(event);
        return "redirect:/event/" + event.getId_event();
    }

    @GetMapping("event/{id}")
    public String oneEvent(@PathVariable("id") int id, Model model){
    Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        return "oneEvent";
    }

    @GetMapping("event/{id}/delete")
    public String deleteEvent(@PathVariable("id") int id, Model model) {
        eventService.deleteEvent(id);
        return "redirect:/event";
    }

    @RequestMapping(value = "/organization")
    public String listorganization(Model model) {
        List<Organization> list = organizationService.organizationList();
        model.addAttribute("organizationList", list);
        return "organization";
    }

    @RequestMapping(value = "/organization/add", method = RequestMethod.GET)
    public String getAddorganization(Model model) {
        model.addAttribute("organization", new Organization());
        return "addOrg";
    }

    @RequestMapping(value = "/organization/add", method = RequestMethod.POST)
    public String addOrganization(@ModelAttribute Organization organization, Model model) {
        model.addAttribute("organization", organization);
        organizationService.addOrganization(organization);
        return "redirect:/organization/" + organization.getId_organization();
    }

    @GetMapping("organization/{id}/delete")
    public String deleteOrganization(@PathVariable("id") int id, Model model) {
        organizationService.deleteOrganiztion(id);
        return "redirect:/organization";
    }

    @GetMapping("organization/{id}")
    public String oneOrganization(@PathVariable("id") int id, Model model){
        Organization organization = organizationService.findOrganization(id);
        model.addAttribute("organization", organization);
        return "oneOrg";
    }

    @GetMapping("/person/{id}/edit")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "updatePerson";
    }
    @PostMapping("person/{id}/update")
    public String updateUser(@PathVariable("id") int id, @Valid Person person,
                             BindingResult result, Model model) {

        person.setId_person(id);
        personService.updatePerson(person);
        return "redirect:/person/" + person.getId_person();
    }


    @GetMapping("/project/{id}/edit")
    public String showProjectForm(@PathVariable("id") int id, Model model) {
        Project project = projectService.findProject(id);
        model.addAttribute("project", project);
        return "updateProject";
    }
    @PostMapping("project/{id}/update")
    public String updateProject(@PathVariable("id") int id, @Valid Project project,
                                BindingResult result, Model model) {
        project = projectService.saveSets(project,id);
        projectService.updateProject(project);
        return "redirect:/project/" + project.getId_project();
    }



    @GetMapping("/event/{id}/edit")
    public String showEventForm(@PathVariable("id") int id, Model model) {
        Event event = eventService.findEvent(id);
        model.addAttribute("event", event);
        return "updateEvent";
    }
    @PostMapping("event/{id}/update")
    public String updateEvent(@PathVariable("id") int id, @Valid Event event,
                              BindingResult result, Model model) {
        event.setId_event(id);
        eventService.updateEvent(event);
        return "redirect:/event/" + event.getId_event();
    }


    @GetMapping("/organization/{id}/edit")
    public String showOrganizationForm(@PathVariable("id") int id, Model model) {
        Organization organization = organizationService.findOrganization(id);
        model.addAttribute("organization", organization);
        return "updateOrganization";
    }
    @PostMapping("organization/{id}/update")
    public String updateOrganization(@PathVariable("id") int id, @Valid Organization organization,
                                     BindingResult result, Model model) {
        organization.setId_organization(id);
        organizationService.updateOrganization(organization);
        return "redirect:/organization/" + organization.getId_organization();
    }


}
