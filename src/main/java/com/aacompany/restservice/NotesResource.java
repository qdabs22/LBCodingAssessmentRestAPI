/*
 * Notes CRUD Rest API Request Resource file. 
 * Handles the CRUD requests for notes.
 */
package com.aacompany.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("notes")
public class NotesResource {
        NoteRepository notesRepos = new NoteRepository();
        
        //get all notes
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Note> getNotes(@QueryParam("body") String body) {
            
            System.out.println("getNotes called");  
            List<Note> allNotes =  notesRepos.getNotes(body);
            return allNotes;
        }   

        //get single note
        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Note getNote(@PathParam("id") int id) {
                           
            System.out.println("getNote called");  
            Note singleNote = notesRepos.getNote(id);
            return singleNote;
        }
        
        //create new note
        @POST
        @Consumes({MediaType.APPLICATION_JSON})
        @Produces(MediaType.APPLICATION_JSON)
        public Note createNote(Note newNote){
            
           System.out.println("createNote called");  
           Note createdNote = notesRepos.createNote(newNote.GetBody());
           return createdNote;
        }
        
        //update a note
        @PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
        public Note updateNote(@PathParam("id") int id, Note note){
            
           System.out.println("updateNote called");  
           return notesRepos.updateNote(id,note.GetBody());
        }
        
        //delete a note
        @DELETE
        @Path("{id}")
        public boolean deleteNote(@PathParam("id") int id){
            
           System.out.println("deleteNote called");  
           return notesRepos.deleteNote(id);         
        }
}