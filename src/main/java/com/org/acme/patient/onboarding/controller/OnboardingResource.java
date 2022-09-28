package com.org.acme.patient.onboarding.controller;

import com.org.acme.patient.onboarding.model.Doctor;
import com.org.acme.patient.onboarding.model.Hospital;
import com.org.acme.patient.onboarding.service.IOnboardingService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Tag(name = "Onboarding Services Endpoints")
@Path("/onboarding")
public class OnboardingResource {

    private final IOnboardingService service;

    public OnboardingResource (IOnboardingService service){
        this.service=service;
    }


    @POST
    @Path("/assignhospital/{zip}")
    public Hospital assignHospitalToPatient(@PathParam("zip") String zip) {
        return service.getParticipatingHospital(zip);
    }

    @POST
    @Path("/assigndoctor/{condition}")
    public Doctor assignDoctorToPatient(@PathParam("condition") String condition) {
        return service.getParticipatingDoctor(condition);
    }

    @POST
    @Path(value = "/notify/{contact}")
    @Produces(MediaType.APPLICATION_JSON)
    public void notifyPatient(@PathParam("contact") String contact) {
        // do nothing here for demo...
        // irl would send email or text message or both
    }

}