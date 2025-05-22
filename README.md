Step-by-Step Summary & Instructions
1. Project Setup
Goal: Initialize the Spring Boot project and connect to GitHub.
Steps:

Created a Spring Boot project using Spring Initializr with:

Dependencies: Spring Web, Thymeleaf, Lombok, Validation.

Java 21, Maven, Spring Boot 3.4.5.

Cloned the repository:

bash
git clone https://github.com/iam-SatheeshMSK/amazon-ecommerce.git
Added project code:

HomeController.java, ShoppingCartController.java, and Thymeleaf templates.

2. Git Branching Strategy
Goal: Adopt a real-world branching workflow.
Steps:

Created core branches:

bash
git checkout -b develop      # Development branch
git checkout -b staging     # Staging branch
Created a feature branch:

bash
git checkout develop
git checkout -b feature/shopping-cart
Pushed branches to GitHub:

bash
git push -u origin develop
git push -u origin feature/shopping-cart
3. CI/CD Pipeline Setup
Goal: Prepare for automation (Jenkins/Docker/AWS).
Steps:

Configured pom.xml for Maven builds.

Added Docker support:

Created a Dockerfile.

Set up AWS CLI for future deployment.

4. Resolving Git Issues
Goal: Fix authentication and branch synchronization.
Steps:

Generated SSH keys and added them to GitHub.

Reconfigured Git remote URL:

bash
git remote set-url origin git@github.com:iam-SatheeshMSK/amazon-ecommerce.git
Force-pushed changes after resolving conflicts:

bash
git push -u origin main --force
5. Creating Pull Requests (PRs)
Goal: Merge features into develop and main.
Steps:

Pushed feature branch:

bash
git push origin feature/shopping-cart
Created PR on GitHub:

Base: develop → Compare: feature/shopping-cart.

Merged after code review.

Step 6: Add a README.md
Goal: Document your project for contributors.
Instructions:

Create README.md in your project root:

bash
touch README.md
Add content (use this template):

markdown
# Amazon-like E-Commerce Platform

A Spring Boot-based e-commerce application mimicking Amazon's core features.

## Features
- User authentication
- Shopping cart management
- Product catalog

## Tech Stack
- **Backend**: Java 21, Spring Boot 3.4.5
- **Frontend**: Thymeleaf, HTML/CSS
- **DevOps**: Jenkins, Docker, AWS, Kubernetes
- **Database**: MySQL (to be added)

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/iam-SatheeshMSK/amazon-ecommerce.git
Run the application:

bash
mvn spring-boot:run
Access at http://localhost:8080.

Branching Strategy
main: Production-ready code.

develop: Integration branch for features.

feature/*: Short-lived feature branches.

hotfix/*: Critical production fixes.

CI/CD Pipeline
Stages:

Build: mvn clean package

Test: Unit/Integration tests.

Deploy: Docker → AWS EKS.

Contributing
Create a feature branch:

bash
git checkout -b feature/your-feature develop
Submit a PR to develop after testing.

Commit and push the README:

bash
git add README.md
git commit -m "docs: add project README"
git push origin main
Final GitHub Repository Structure
amazon-ecommerce/
├── src/
├── pom.xml
├── Dockerfile
├── README.md         # Your documentation
└── .github/workflows # CI/CD workflows (to be added)
