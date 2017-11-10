import { InquryService } from '../inqury.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-topnavbar',
  templateUrl: './topnavbar.component.html',
  styleUrls: ['./topnavbar.component.css'],
  providers: [InquryService]
})

export class TopNavBarComponent {
}
