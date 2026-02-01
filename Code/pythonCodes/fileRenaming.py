import os

def rename_files_in_directory(directory_path):
    try:
        # Get a list of all files in the directory
        files = os.listdir(directory_path)
        # Filter out directories from the list
        files = [f for f in files if os.path.isfile(os.path.join(directory_path, f))]
        
        # Sort the files to maintain a consistent order
        files.sort()
        
        # Loop through the files and rename them
        for idx, filename in enumerate(files):
            # Get the file extension
            file_extension = os.path.splitext(filename)[1]
            # Construct the new file name
            new_filename = f"{idx + 1}{file_extension}"
            # Construct full file paths
            old_file = os.path.join(directory_path, filename)
            new_file = os.path.join(directory_path, new_filename)
            # Rename the file
            os.rename(old_file, new_file)
        
        print("Files renamed successfully.")
    except Exception as e:
        print(f"An error occurred: {e}")

# Specify the directory path
directory_path = r"D:\Papers"

# Call the function to rename files
rename_files_in_directory(directory_path)
