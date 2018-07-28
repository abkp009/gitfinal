package com.security.ldap.ldapsecuritydemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.ldap.ldapsecuritydemo.commandform.Hero;

@RestController
public class HerosController {
	@RequestMapping("/heros")
	public List<Hero> getHeros() {
		List<Hero> list = new ArrayList<>();
		Hero hero = null;
		for (int i = 0; i < 5; i++) {
			hero = new Hero();
			hero.setId(i + 1);
			hero.setName("Hero" + (i + 1));
			list.add(hero);
		}
		return list;
	}
}
