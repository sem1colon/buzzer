# Buzzer UI

An Ionic Angular frontend application for the Buzzinga online buzzer system. This mobile-responsive web application provides an intuitive interface for hosts to create contests and participants to join buzzer competitions.

## Overview

The Buzzer UI provides:
- **Home page** - Landing page with options to create or join contests
- **Create contest** - Interface for hosts to set up new buzzer competitions
- **Join contest** - Interface for participants to join existing contests using contest codes
- **Real-time buzzer functionality** - Interactive buzzer interface for competitive events

## Tech Stack

- **Ionic 5.5.2** - Cross-platform mobile app framework
- **Angular 12.1.1** - Frontend framework
- **TypeScript 4.2.4** - Programming language
- **Capacitor 3.2.2** - Native runtime for web apps
- **Bootstrap 5.1.1** - CSS framework for styling
- **RxJS 6.6.0** - Reactive programming library

## Project Structure

```
src/
├── app/
│   ├── app-routing.module.ts          # Application routing configuration
│   ├── app.module.ts                  # Root module
│   ├── app.component.*                # Root component
│   ├── home/                          # Home page module
│   │   ├── home.page.html            # Home page template
│   │   ├── home.page.ts              # Home page component
│   │   ├── home.page.scss            # Home page styles
│   │   └── home.module.ts            # Home page module
│   ├── create/                        # Create contest module
│   │   ├── create.page.html          # Create contest template
│   │   ├── create.page.ts            # Create contest component
│   │   ├── create.page.scss          # Create contest styles
│   │   └── create.module.ts          # Create contest module
│   └── join/                          # Join contest module
│       ├── join.page.html            # Join contest template
│       ├── join.page.ts              # Join contest component
│       ├── join.page.scss            # Join contest styles
│       └── join.module.ts            # Join contest module
├── assets/                            # Static assets
│   ├── icon/                         # App icons
│   └── shapes.svg                    # SVG graphics
├── environments/                      # Environment configurations
│   ├── environment.ts                # Development environment
│   └── environment.prod.ts           # Production environment
├── theme/
│   └── variables.scss                # Global SCSS variables
├── global.scss                       # Global styles
├── index.html                        # Main HTML file
└── main.ts                          # Application bootstrap
```

## Prerequisites

- **Node.js** 14+ and npm
- **Ionic CLI**: `npm install -g @ionic/cli`
- **Angular CLI**: `npm install -g @angular/cli`

## Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
cd buzzer/ui
```

### 2. Install dependencies
```bash
npm install
```

### 3. Run the development server
```bash
# Start Ionic development server
ionic serve

# Or using Angular CLI
ng serve

# Or using npm script
npm start
```

The application will be available at: `http://localhost:8100`

## Available Scripts

- `npm start` - Start development server
- `npm run build` - Build the project for production
- `npm test` - Run unit tests with Karma
- `npm run lint` - Run ESLint for code quality
- `npm run e2e` - Run end-to-end tests

## Building for Production

### Web Build
```bash
# Build for web
ionic build --prod

# Or using Angular CLI
ng build --prod
```

### Mobile Build (iOS/Android)

1. **Add platform**:
```bash
# Add iOS platform
ionic capacitor add ios

# Add Android platform  
ionic capacitor add android
```

2. **Build and sync**:
```bash
# Build web assets and sync to native
ionic capacitor build ios
ionic capacitor build android
```

3. **Open in native IDE**:
```bash
# Open Xcode for iOS
ionic capacitor open ios

# Open Android Studio for Android
ionic capacitor open android
```

## Configuration

### Environment Variables

Configure API endpoints and other settings in:
- `src/environments/environment.ts` (development)
- `src/environments/environment.prod.ts` (production)

Example configuration:
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/buzzer',
  version: '0.0.1'
};
```

### Capacitor Configuration

Mobile app settings in `capacitor.config.json`:
```json
{
  "appId": "com.sem1colon.buzzer",
  "appName": "Buzzinga",
  "webDir": "www",
  "bundledWebRuntime": false
}
```

## Routing

The application uses Angular routing with lazy-loaded modules:

- `/` - Home page (landing page)
- `/create` - Create contest page
- `/join` - Join contest page

## Styling

The application uses:
- **Ionic Components** - Pre-built mobile UI components
- **Bootstrap 5** - Additional CSS utilities and components
- **SCSS** - Enhanced CSS with variables and mixins
- **CSS Custom Properties** - Theming and customization

Global styles are defined in:
- `src/global.scss` - Global application styles
- `src/theme/variables.scss` - CSS custom properties and theme variables

## Testing

### Unit Tests
```bash
# Run unit tests
npm test

# Run tests in watch mode
npm test -- --watch

# Run tests with coverage
npm test -- --code-coverage
```

### End-to-End Tests
```bash
# Run e2e tests
npm run e2e

# Run e2e tests headlessly
npm run e2e -- --headless
```

## Development Guidelines

### Code Style
- Follow Angular and Ionic best practices
- Use TypeScript strict mode
- Follow component-based architecture
- Use lazy loading for better performance

### Component Structure
```typescript
@Component({
  selector: 'app-example',
  templateUrl: './example.page.html',
  styleUrls: ['./example.page.scss'],
})
export class ExamplePage implements OnInit {
  constructor() { }

  ngOnInit() {
    // Initialization logic
  }
}
```

### Adding New Pages
1. Generate new page: `ionic generate page pages/new-page`
2. Add routing in `app-routing.module.ts`
3. Update navigation as needed

## Performance Optimization

- **Lazy Loading** - All pages are lazy-loaded modules
- **OnPush Change Detection** - Use for better performance
- **Track By Functions** - Use with *ngFor for large lists
- **Image Optimization** - Compress images in assets folder

## PWA Features

The app can be configured as a Progressive Web App:
- Service worker for offline functionality
- App manifest for installability
- Push notifications support

## Troubleshooting

### Common Issues

1. **Port already in use**:
```bash
ionic serve --port 8101
```

2. **Node modules issues**:
```bash
rm -rf node_modules package-lock.json
npm install
```

3. **Capacitor sync issues**:
```bash
ionic capacitor sync
```

4. **iOS build issues**:
```bash
cd ios/App
pod install
```

### Development Tips
- Use browser developer tools for debugging
- Test on multiple screen sizes using device emulation
- Use Ionic DevApp for testing on real devices
- Check console for TypeScript/Angular errors

## Deployment

### Web Deployment
1. Build for production: `ionic build --prod`
2. Deploy `www/` folder to web server
3. Configure server for SPA routing

### App Store Deployment
1. Build native apps using Capacitor
2. Follow platform-specific guidelines:
   - iOS: App Store Connect
   - Android: Google Play Console

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-feature`
3. Make your changes following the coding standards
4. Add tests for new functionality
5. Ensure all tests pass: `npm test`
6. Lint your code: `npm run lint`
7. Commit your changes: `git commit -m 'Add new feature'`
8. Push to the branch: `git push origin feature/new-feature`
9. Submit a pull request

## Browser Support

- **Modern browsers** - Chrome, Firefox, Safari, Edge (latest versions)
- **Mobile browsers** - iOS Safari, Chrome Mobile, Samsung Internet
- **PWA support** - Chrome, Firefox, Safari, Edge

## License

This project is part of the Buzzinga application. See the main project README for license information.

## Support

For issues and questions:
- Create an issue in the main repository
- Check Ionic documentation: https://ionicframework.com/docs
- Check Angular documentation: https://angular.io/docs
- Review browser console for runtime errors

## Useful Resources

- [Ionic Framework Documentation](https://ionicframework.com/docs)
- [Angular Documentation](https://angular.io)
- [Capacitor Documentation](https://capacitorjs.com)
- [Ionic Native/Capacitor Plugins](https://capacitorjs.com/docs/plugins)