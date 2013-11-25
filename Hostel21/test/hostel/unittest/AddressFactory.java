package hostel.unittest;

import hostel.core.Address;



/**
 * The class <code>AddressFactory</code> implements static methods that return instances of the class <code>{@link Address}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:53 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class AddressFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	private AddressFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress() {
		return new Address("", "", "", "", "");
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress2() {
		return new Address("0123456789", "0123456789", "0123456789", "0123456789", "");
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress3() {
		return new Address("0123456789", "0123456789", "0123456789", "0123456789", "0123456789");
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress4() {
		return new Address("An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt");
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress5() {
		return new Address();
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress6() {
		return new Address((Address) null);
	}


	/**
	 * Create an instance of the class <code>{@link Address}</code>.
	 *
	 * @generatedBy CodePro at 11/22/13 12:53 PM
	 */
	public static Address createAddress7() {
		return new Address((String) null, (String) null, (String) null, (String) null, (String) null);
	}
}