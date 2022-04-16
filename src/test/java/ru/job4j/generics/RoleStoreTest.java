package ru.job4j.generics;



import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleNameIsReader() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Reader"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsReader() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        store.add(new Role("1", "Writer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Reader"));
    }

    @Test
    public void whenReplaceThenRoleNameIsWriter() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        store.replace("1", new Role("1", "Writer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Writer"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        store.replace("10", new Role("10", "Writer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Reader"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleNameIsReader() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Reader"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Reader"));
    }

}
