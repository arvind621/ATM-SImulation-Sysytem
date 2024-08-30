# Step 1: Create the README.md file with the content
echo "# ATM Simulation System

## Overview
The ATM Simulation System is a basic Java application that simulates the functionality of an Automated Teller Machine (ATM). It includes operations such as account creation, balance inquiries, deposits, and withdrawals.

## Features
- Account Management
- Balance Inquiry
- Deposits and Withdrawals

## Installation
1. Clone the repository:
   \`\`\`bash
   git clone https://github.com/arvind621/ATM-SImulation-Sysytem.git
   \`\`\`
2. Compile the Java files:
   \`\`\`bash
   javac ATM.java Account.java
   \`\`\`
3. Run the application:
   \`\`\`bash
   java ATM
   \`\`\`

## Usage
After running the application, follow the on-screen instructions to perform various banking operations.

## Contributing
Feel free to submit issues or pull requests for improvements!

## License
This project is open source and available under the MIT License.
" > README.md

# Step 2: Stage the README.md file
git add README.md

# Step 3: Commit the README.md file
git commit -m "Add README.md file"

# Step 4: Push the changes to GitHub
git push origin master

