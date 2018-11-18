/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * The abstract class {@link BaseComparatorTestCase} is for unit tests with {@link Comparator}. An
 * example is in the unit test class <code>DateComparatorTest</code> in project silly-collections
 *
 * @author Asterios Raptis
 * @version 1.0
 * @param <T>
 *            the generic type of the objects to compare
 */
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseComparatorTestCase<T> extends AbstractTestCase<Integer, Boolean>
{

	/** The comparator. */
	Comparator<T> comparator;

	/** The first comparison object. */
	T o1;

	/** The other object to compare. */
	T o2;

	/**
	 * Abstract factory callback method that have to be overwritten for create the {@link List} with
	 * objects to sort in the sort scenario.
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newActualList();

	/**
	 * Abstract factory callback method that have to be overwritten for create the specific
	 * comparator object
	 *
	 * @return the specific comparator
	 */
	protected abstract Comparator<T> newComparator();

	/**
	 * Abstract factory callback method that have to be overwritten for create the expected
	 * {@link List} with objects to test the sort algorithm in the sort scenario.
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newExpectedSortedList();

	/**
	 * Abstract factory callback method that have to be overwritten for create the {@link List} with
	 * objects to sort in the sort scenario. <br>
	 * <br>
	 * Note:This list have to be equal with {@link BaseComparatorTestCase#newActualList()}
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newExpectedUnsortedList();

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario that the objects are equal.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO1Equal();

	/**
	 * Abstract factory callback method that have to be overwritten for create the first comparison
	 * object in the scenario greater than.
	 *
	 * @return the new created first comparison object
	 */
	protected abstract T newO1GreaterThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the first comparison
	 * object in the scenario less than.
	 *
	 * @return the new created first comparison object
	 */
	protected abstract T newO1LessThan();

	/**
	 * Factory callback method that can be overwritten for create the other object to compare in the
	 * scenario that the objects are equal.
	 *
	 * @return the new created object to compare
	 */
	protected T newO2Equal()
	{
		return newO1Equal();
	}

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario greater than.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO2GreaterThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario less than.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO2LessThan();

	/**
	 * {@inheritDoc}
	 */
	@Override
	@BeforeMethod
	public void setUp()
	{
		comparator = newComparator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@AfterMethod
	public void tearDown()
	{
		comparator = null;
		o1 = null;
		o2 = null;
	}

	/**
	 * Test method for {@link Comparator#compare(Object, Object)}
	 */
	public void testCompare()
	{
		List<T> actual;
		List<T> expected;
		actual = newActualList();
		expected = newExpectedUnsortedList();
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
		// sort...
		Collections.sort(actual, comparator);
		expected = newExpectedSortedList();
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	/**
	 * Test scenario when comparison objects are equal.
	 */
	public void testEqual()
	{
		o1 = newO1Equal();
		o2 = newO2Equal();

		actual = comparator.compare(o1, o2);
		expected = actual == 0;
		assertTrue(expected);

		o1 = newO1Equal();
		o2 = o1;

		actual = comparator.compare(o1, o2);
		expected = actual == 0;
		assertTrue(expected);
	}

	/**
	 * Test scenario when a comparison object is greater than the other object to compare.
	 */
	public void testGreaterThan()
	{
		o1 = newO1GreaterThan();
		o2 = newO2GreaterThan();

		actual = comparator.compare(o1, o2);
		expected = actual > 0;
		assertTrue(expected);

		o1 = newO1GreaterThan();
		o2 = null;

		actual = comparator.compare(o1, o2);
		expected = actual > 0;
		assertTrue(expected);
	}

	/**
	 * Test scenario when a comparison object is less than the other object to compare.
	 */
	public void testLessThan()
	{
		o1 = newO1LessThan();
		o2 = newO2LessThan();

		actual = comparator.compare(o1, o2);
		expected = actual < 0;
		assertTrue(expected);

		o1 = null;
		o2 = newO2LessThan();

		actual = comparator.compare(o1, o2);
		expected = actual < 0;
		assertTrue(expected);
	}

}
