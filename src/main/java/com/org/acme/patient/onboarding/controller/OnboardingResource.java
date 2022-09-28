package com.org.acme.patient.onboarding.controller;

import com.org.acme.patient.onboarding.service.IOnboardingService;
import org.acme.patient.onboarding.model.Doctor;
import org.acme.patient.onboarding.model.Hospital;
import org.acme.patient.onboarding.model.Patient;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/onboarding")
public class OnboardingResource {

    private final IOnboardingService service;

    public OnboardingResource (IOnboardingService service){
        this.service=service;
    }


    @POST
    public Patient doOnboard( Patient patient){
        return null;
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