package maintest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.User;
import util.UserAnalyzer;

public class UserClassifierTest {

	@Test
	public void testsSituationFrontDev() {
		User candidate = new User();
		candidate.setCssSkill(9);
		candidate.setJavaScriptSkill(9);
		candidate.setHtmlSkill(9);

		UserAnalyzer analyzer = new UserAnalyzer(candidate);

		assertTrue(analyzer.isFrontEndDev());
		assertFalse(analyzer.isBeginner());

		candidate.setHtmlSkill(6);
		candidate.setCssSkill(7);
		candidate.setJavaScriptSkill(9);

		analyzer = new UserAnalyzer(candidate);
		assertFalse(analyzer.isFrontEndDev());
		assertTrue(analyzer.isBeginner());

	}
	
	@Test
	public void testsSituationBackDev() {
		User candidate = new User();
		candidate.setPythonSkill(9);
		candidate.setDjangoSkill(9);

		UserAnalyzer analyzer = new UserAnalyzer(candidate);

		assertTrue(analyzer.isBackEndDev());
		assertFalse(analyzer.isBeginner());

		candidate.setPythonSkill(6);
		candidate.setDjangoSkill(7);

		analyzer = new UserAnalyzer(candidate);
		assertFalse(analyzer.isBackEndDev());
		assertTrue(analyzer.isBeginner());

	}

	@Test
	public void testsSituationMobileDev() {
		User candidate = new User();
		candidate.setIosSkill(9);
		candidate.setAndroidSkill(9);

		UserAnalyzer analyzer = new UserAnalyzer(candidate);

		assertTrue(analyzer.isMobileDev());
		assertFalse(analyzer.isBeginner());

		candidate.setIosSkill(6);
		candidate.setAndroidSkill(5);

		analyzer = new UserAnalyzer(candidate);
		assertFalse(analyzer.isMobileDev());
		assertTrue(analyzer.isBeginner());
		
		candidate.setIosSkill(7);
		candidate.setAndroidSkill(5);

		analyzer = new UserAnalyzer(candidate);
		
		assertTrue(analyzer.isMobileDev());
	}
}
