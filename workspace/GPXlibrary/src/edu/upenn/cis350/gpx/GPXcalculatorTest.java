/*
 * Author: Mainak Datta
 * CIS 350
 * Tester for unimplemented GPXcalculator
 */


package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class GPXcalculatorTest {

	//Tests for GPXtrk	
	@Test
	public void testDistanceTraveled() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkpt c = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt d = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(c); pts.add(d);
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),2*(Math.sqrt(50*50*2)), 0);
	}
	

	@Test
	public void testNullTrack() {
		GPXtrk tk = null;
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk), -1 , 0);
	}
	
	@Test
	public void testEmptyTrack() {
		ArrayList<GPXtrkseg> isEmpty = new ArrayList<GPXtrkseg>();
		GPXtrk tk = new GPXtrk("empty", isEmpty);
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk), -1 , 0);
	}
	
	//If the array in GPXtrk is null, should do the same as if the GPXtrk object was null
	@Test
	public void testNullTrackArray() {
		ArrayList<GPXtrkseg> isNull = null;
		GPXtrk tk = new GPXtrk("null", isNull);
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk), -1 , 0);
	}
	
	@Test
	public void testNullGPXSeg() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkseg seg2 = null;
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),(Math.sqrt(50*50*2)), 0);
	}
	
	//Tests for GPXtrkseg
	@Test
	//If a GPXtrkseg has a null array, it should be treated as if that GPXtrkseg object was null
	public void testsegNullArray() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		ArrayList<GPXtrkpt> pts = null;
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),Math.sqrt(50*50*2), 0);
	}
	
	@Test
	public void testSegEmptyArray() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),Math.sqrt(50*50*2), 0);
	}
	
	@Test
	public void testOnePointInSeg() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkpt d = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(d);
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),(Math.sqrt(50*50*2)), 0);
	}
	
	@Test
	public void testNullTrkPoint() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkpt c = null;
		GPXtrkpt d = null;
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(c); pts.add(d);
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk),(Math.sqrt(50*50*2)), 0);
	}
	
	@Test
	//Tests for GPXtrkpt
	public void testPointLatBounds() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(100, 50, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkpt c = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt d = new GPXtrkpt(-100, 50, new Date());
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(c); pts.add(d);
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk), 0 , 0);
	}
	
	@Test
	public void testPointLonBounds() {
		GPXtrkpt a = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt b = new GPXtrkpt(50, 150, new Date());
		ArrayList<GPXtrkpt> points = new ArrayList<GPXtrkpt>();
		points.add(a); points.add(b);
		GPXtrkseg seg1 = new GPXtrkseg(points);
		
		GPXtrkpt c = new GPXtrkpt(0.0, 0.0 , new Date());
		GPXtrkpt d = new GPXtrkpt(50, -150, new Date());
		ArrayList<GPXtrkpt> pts = new ArrayList<GPXtrkpt>();
		pts.add(c); pts.add(d);
		GPXtrkseg seg2 = new GPXtrkseg(pts);
		
		ArrayList<GPXtrkseg> segs = new ArrayList<GPXtrkseg>();
		segs.add(seg1); segs.add(seg2);
		GPXtrk tk = new GPXtrk("track",segs);
		
		assertEquals(GPXcalculator.calculateDistanceTraveled(tk), 0 , 0);
	}
}
