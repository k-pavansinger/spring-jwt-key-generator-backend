import base64
import secrets

def generate_hs512_secret_key():
    """
    Generate a cryptographically secure secret key for HS512 algorithm.
    
    Returns:
        tuple: (base64_encoded_secret, hex_secret, raw_secret)
    """
    # Generate 64 bytes (512 bits) of cryptographically secure random bytes
    raw_secret = secrets.token_bytes(64)
    
    # Base64 encode the secret (common in JWT contexts)
    base64_secret = base64.b64encode(raw_secret).decode('utf-8')
    
    # Hex representation 
    hex_secret = raw_secret.hex()
    
    return base64_secret, hex_secret, raw_secret

def main():
    # Generate the HS512 secret key
    base64_secret, hex_secret, _ = generate_hs512_secret_key()
    
    print("HS512 JWT Secret Key (Base64 Encoded):", base64_secret)
    print("HS512 Secret Key (Hex Encoded):", hex_secret)
    print("\nKey Length:")
    print("- Bytes:", 64)
    print("- Bits:", 64 * 8)
    
    print("\nYou can use this in your Java configuration:")
    print(f"jwtSecret = \"{base64_secret}\"")

if __name__ == "__main__":
    main()