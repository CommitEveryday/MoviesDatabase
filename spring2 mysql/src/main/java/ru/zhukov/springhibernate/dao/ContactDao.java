/**
 * Created on Oct 12, 2011
 */
package ru.zhukov.springhibernate.dao;

import java.util.List;

import ru.zhukov.springhibernate.domain.Contact;

/**
 *
 *
 */
public interface ContactDao {

	// Find all contacts
	public List<Contact> findAll();
	
	// Find all contacts with telephone and hobbies
	public List<Contact> findAllWithDetail();
	
	// Find a contact with details by id
	public Contact findById(Long id);
	
	// Insert or update a contact
	public Contact save(Contact contact);
	
	// Delete a contact
	public void delete(Contact contact);
}
