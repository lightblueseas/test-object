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
package de.alpharogroup.test.objects;

import java.io.Serializable;

import de.alpharogroup.test.objects.annotations.Mandatory;
import de.alpharogroup.test.objects.enums.Brands;

/**
 * The class {@link Customer} is a class intended for use in unit tests.
 */
public class Customer implements Serializable
{
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The car.
	 */
	public Brands car;
	/**
	 * The name.
	 */
	@Mandatory
	public String name;
	/**
	 * The premium.
	 */
	public boolean premium;

	private static Brands $default$car()
	{
		return Brands.FERRARI;
	}

	private static String $default$name()
	{
		return "";
	}

	public static class CustomerBuilder
	{

		private boolean car$set;

		private Brands car;

		private boolean name$set;

		private String name;

		private boolean premium;

		CustomerBuilder()
		{
		}

		public CustomerBuilder car(final Brands car)
		{
			this.car = car;
			car$set = true;
			return this;
		}

		public CustomerBuilder name(final String name)
		{
			this.name = name;
			name$set = true;
			return this;
		}

		public CustomerBuilder premium(final boolean premium)
		{
			this.premium = premium;
			return this;
		}

		public Customer build()
		{
			Brands car = this.car;
			if (!car$set)
				car = Customer.$default$car();
			String name = this.name;
			if (!name$set)
				name = Customer.$default$name();
			return new Customer(car, name, premium);
		}

		@Override
		public String toString()
		{
			return "Customer.CustomerBuilder(car=" + this.car + ", name=" + this.name + ", premium="
				+ this.premium + ")";
		}
	}

	public static CustomerBuilder builder()
	{
		return new CustomerBuilder();
	}

	public CustomerBuilder toBuilder()
	{
		return new CustomerBuilder().car(this.car).name(this.name).premium(this.premium);
	}

	public Brands getCar()
	{
		return this.car;
	}

	public String getName()
	{
		return this.name;
	}

	public boolean isPremium()
	{
		return this.premium;
	}

	public Customer setCar(final Brands car)
	{
		this.car = car;
		return this;
	}

	public Customer setName(final String name)
	{
		this.name = name;
		return this;
	}

	public Customer setPremium(final boolean premium)
	{
		this.premium = premium;
		return this;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Customer))
			return false;
		final Customer other = (Customer)o;
		if (!other.canEqual((Object)this))
			return false;
		final Object this$car = this.getCar();
		final Object other$car = other.getCar();
		if (this$car == null ? other$car != null : !this$car.equals(other$car))
			return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name))
			return false;
		if (this.isPremium() != other.isPremium())
			return false;
		return true;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof Customer;
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $car = this.getCar();
		result = result * PRIME + ($car == null ? 43 : $car.hashCode());
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		result = result * PRIME + (this.isPremium() ? 79 : 97);
		return result;
	}

	@Override
	public String toString()
	{
		return "Customer(car=" + this.getCar() + ", name=" + this.getName() + ", premium="
			+ this.isPremium() + ")";
	}

	public Customer()
	{
		this.car = Customer.$default$car();
		this.name = Customer.$default$name();
	}

	public Customer(final Brands car, final String name, final boolean premium)
	{
		this.car = car;
		this.name = name;
		this.premium = premium;
	}
}