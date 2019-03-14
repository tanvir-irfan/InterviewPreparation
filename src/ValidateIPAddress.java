
public class ValidateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "256.256.256.256";

		ValidateIPAddress vip = new ValidateIPAddress();

		System.out.println(vip.isValidIP(ip));

	}

	private String isValidIP(String ip) {
		if (ip.contains(".")) {
			return isValidIP4V(ip.split("\\."));
		} else if (ip.contains(":")) {
			return isValidIP6V(ip.split("\\:"));
		} else {
			return "Neither";
		}
	}

	private String isValidIP6V(String[] ipParts) {
		boolean res = true;

		if (ipParts.length == 8) {
			for (String s : ipParts) {
				if (s.isEmpty() || s.charAt(0) == '0' || Integer.parseInt(s) >= 256) {
					res = false;
					break;
				}
			}
		} else {
			res = false;
		}

		return res ? "IPv6" : "Neither";
	}

	private String isValidIP4V(String[] ipParts) {

		boolean res = true;

		if (ipParts.length == 4) {
			for (String s : ipParts) {
				if (s.isEmpty() || s.charAt(0) == '0' || Integer.parseInt(s) >= 256) {
					res = false;
					break;
				}
			}
		} else {
			res = false;
		}

		return res ? "IPv4" : "Neither";
	}

}
