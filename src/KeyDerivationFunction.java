public class KeyDerivationFunction {
    public static void main(String[] args) throws Exception {
        String password = "my_secure_password";
        byte[] salt = new byte[]{(byte) 0xA1, (byte) 0xB2, (byte) 0xC3, (byte) 0xD4};

        // Deriving a key using PBKDF2 (Key Derivation Algorithm)
        javax.crypto.SecretKeyFactory factory = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        javax.crypto.spec.PBEKeySpec spec = new javax.crypto.spec.PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        javax.crypto.SecretKey secretKey = factory.generateSecret(spec);

        System.out.println("Derived Key: " + new String(secretKey.getEncoded()));
    }
}
