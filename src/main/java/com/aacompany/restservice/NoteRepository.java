/*
 * Notes Mock Up Data Repository
 */
package com.aacompany.restservice;

//imports
import java.util.ArrayList;
import java.util.List;

/**
 * Notes Repository 
 * Class which holds the mock up data for the Notes Rest API
 */
public class NoteRepository {
    
    List<Note> notes;
    
    //Constructor 
    //Sets up inital Note Data
    public NoteRepository()
    {
        notes = new ArrayList<>();
        
	Note note1 = new Note();
	note1.SetBody("Pick up Milk");
	note1.SetId(1);
		            
	Note note2 = new Note();
	note2.SetBody("Put gas in car");
	note2.SetId(2);   
        
        notes.add(note1);
        notes.add(note2);
    }
    
    //Get All Notes
    public List<Note> getNotes(String bodyFilter){
        
        //check if there is a query param for filtering
        if(bodyFilter != null && !bodyFilter.trim().isEmpty()){
            List<Note> results = new ArrayList<>();
            
            //apply filter
            for (Note note : notes){
                String noteBody = note.GetBody();
                if (noteBody.contains(bodyFilter)){
                    results.add(note);
                }
            }
            return results;
       }
         
        //no filter, return all notes
        return notes;
    }
    
    //Get Single Note based on ID sent in
    public Note getNote(int id){
        for (Note note : notes) {
            if (note.GetId()==id){
                return note;
            }
        }
            return null;
    }
    
    //Creates New Note
    //In Prodution this method would handle adding the note to the database
    //and returning the note with it's associated id.
    //Since this is a class for mock up data, a note will just 
    //be created and returned with unsed id
    public Note createNote(String body){
        
        Note newNote = new Note();
        newNote.SetBody(body);
        newNote.SetId(3);
        return(newNote);
    }
    
    //Delete Note
    //In Prodution this method would handle removing the note from the database
    //and return boolean if delete was succesful or not.
    //Since this is a class for mock up data, data will not actually be removed.
    public boolean deleteNote(int id){
         for (Note note : notes) {
            if (note.GetId()==id){
                notes.remove(note);
                return true;
            }
         }
        return false;
    }
    
    //Update an existing Note 
    //Production - Would update an existing note
    // based on id and return.
    //This example will just return the updated note that was passed in.
    public Note updateNote(int id, String updatedNote){
       
        for (Note note : notes) {
            if (note.GetId()==id){
                
                note.SetBody(updatedNote);
                note.SetId(id);
                return note;            }
        }
            return null;
    }
}
